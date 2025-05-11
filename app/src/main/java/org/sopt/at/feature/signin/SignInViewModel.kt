package org.sopt.at.feature.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.core.utils.PreferenceUtil
import org.sopt.at.data.dto.request.SignInRequest
import org.sopt.at.data.service.TvingService
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val tvingService: TvingService,
    private val preferenceUtil: PreferenceUtil
) : ViewModel() {

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess = _loginSuccess.asStateFlow()

    private val _loginError = MutableStateFlow<String?>(null)
    val loginError = _loginError.asStateFlow()

    fun postSignIn(id: String, pw: String) {
        viewModelScope.launch {
            runCatching {
                tvingService.postSignIn(SignInRequest(id, pw))
            }.onSuccess { result ->
                if (result.success && result.data != null) {
                    val userId = result.data.userId
                    preferenceUtil.saveUserId(userId)
                    preferenceUtil.saveLoginState(true)
                    _loginSuccess.value = true
                } else {
                    _loginError.value = result.message
                }
            }.onFailure {
                _loginError.value = it.message ?: "네트워크 오류"
            }
        }
    }

    fun clearState() {
        _loginSuccess.value = false
        _loginError.value = null
    }
}