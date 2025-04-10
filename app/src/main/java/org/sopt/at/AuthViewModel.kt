package org.sopt.at

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {
    var inputId by mutableStateOf("")
        private set

    var inputPw by mutableStateOf("")
        private set

    val isIdValid: Boolean
        get() = Regex("^[a-z0-9]{6,12}$").matches(inputId)

    val isPwValid: Boolean
        get() = Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#\$%^&*])[A-Za-z\\d~!@#\$%^&*]{8,15}\$")
            .matches(inputPw)

    var isPasswordScreen by mutableStateOf(false)
        private set

    fun onIdChange(newId: String) {
        inputId = newId
    }

    fun onPwChange(newPw: String) {
        inputPw = newPw
    }

    private val _navigateToSignIn = MutableStateFlow(false)
    val navigateToSignIn = _navigateToSignIn.asStateFlow()

    fun onScreenChange() {
        if (isPasswordScreen) {
            if (isIdValid && isPwValid) {
                _navigateToSignIn.value = true
            }
        } else {
            isPasswordScreen = true
        }
    }

    fun onNavigated() {
        _navigateToSignIn.value = false
    }
}