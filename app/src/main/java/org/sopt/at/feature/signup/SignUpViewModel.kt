package org.sopt.at.feature.signup

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.data.dto.request.SignUpRequest
import org.sopt.at.data.service.TvingService
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val tvingService: TvingService
) : ViewModel() {

    enum class Screen {
        ID,
        PW,
        NICKNAME
    }

    var inputId by mutableStateOf("")
        private set

    var inputPw by mutableStateOf("")
        private set

    var inputNickname by mutableStateOf("")
        private set

    val isIdValid: Boolean
        get() = Regex("^[a-z0-9]{6,12}$").matches(inputId)

    val isPwValid: Boolean
        get() = Regex("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$")
            .matches(inputPw)

    var screenState by mutableStateOf(Screen.ID)
        private set

    private val _navigateToSignIn = MutableStateFlow(false)
    val navigateToSignIn = _navigateToSignIn.asStateFlow()

    private val _signUpError = MutableStateFlow<String?>(null)
    val signUpError = _signUpError.asStateFlow()

    fun onIdChange(newId: String) {
        inputId = newId
    }

    fun onPwChange(newPw: String) {
        inputPw = newPw
    }

    fun onNicknameChange(newNickname: String) {
        inputNickname = newNickname
    }

    fun onScreenChange() {
        screenState = when (screenState) {
            Screen.ID -> Screen.PW
            Screen.PW -> Screen.NICKNAME
            Screen.NICKNAME -> {
                postSignUp()
                return
            }
        }
    }

    fun onNavigated() {
        _navigateToSignIn.value = false
    }

    private fun postSignUp() {
        val tag = "SignUpViewModel"

        viewModelScope.launch {
            runCatching {
                tvingService.postSignUp(
                    SignUpRequest(
                        loginId = inputId,
                        password = inputPw,
                        nickname = inputNickname
                    )
                )
            }.onSuccess { result ->
                if (result.success) {
                    _navigateToSignIn.value = true
                } else {
                    _signUpError.value = result.message
                }
            }.onFailure {
                Log.e(tag, "SignUp 네트워크 오류: ${it.message}", it)
                _signUpError.value = it.message ?: "네트워크 오류"
            }
        }
    }
}