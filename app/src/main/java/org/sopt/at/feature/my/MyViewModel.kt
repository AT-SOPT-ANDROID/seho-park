package org.sopt.at.feature.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.core.utils.PreferenceUtil
import org.sopt.at.data.service.TvingService
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val preferenceUtil: PreferenceUtil,
    private val tvingService: TvingService
) : ViewModel() {

    private val _nickname = MutableStateFlow("불러오는 중...")
    val nickname = _nickname.asStateFlow()

    init {
        getNicknameFromServer()
    }

    private fun getNicknameFromServer() {
        val userId = preferenceUtil.getUserId()
        if (userId == -1L) {
            _nickname.value = "로그인 정보 없음"
            return
        }

        viewModelScope.launch {
            runCatching {
                tvingService.getUserNickname(userId)
            }.onSuccess {
                if (it.success && it.data != null) {
                    _nickname.value = it.data.nickname
                } else {
                    _nickname.value = "닉네임 없음"
                }
            }.onFailure {
                _nickname.value = "서버 에러: ${it.message}"
            }
        }
    }
}