package org.sopt.at.feature.signup

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.at.core.components.InputField
import org.sopt.at.core.components.SignUpButton
import org.sopt.at.core.components.Title
import org.sopt.at.core.components.TobBar
import org.sopt.at.ui.theme.BasicBlack


@Composable
fun SignUpRoute(
    padding: PaddingValues,
    navigateToSignIn: (id: String, pw: String) -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    SignUpScreen(
        padding = padding,
        modifier = Modifier,
        viewModel = viewModel,
        navigateToSignIn = navigateToSignIn,
    )
}

@Composable
fun SignUpScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel,
    navigateToSignIn: (id: String, pw: String) -> Unit,
) {
    val inputId = viewModel.inputId
    val inputPw = viewModel.inputPw
    val inputNickname = viewModel.inputNickname
    val isIdValid = viewModel.isIdValid
    val isPwValid = viewModel.isPwValid
    val screenState = viewModel.screenState

    val shouldNavigate by viewModel.navigateToSignIn.collectAsState()

    LaunchedEffect(shouldNavigate) {
        if (shouldNavigate) {
            navigateToSignIn(inputId, inputPw)
            viewModel.onNavigated()
        }
    }

    val context = LocalContext.current

    Column(
        modifier = modifier
            .background(BasicBlack)
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp)
    ) {
        TobBar()
        Spacer(modifier = Modifier.height(16.dp))
        when (screenState) {
            SignUpViewModel.Screen.ID -> {
                IdView(
                    inputId = inputId,
                    onValueChange = viewModel::onIdChange
                )
            }

            SignUpViewModel.Screen.PW -> {
                PwView(
                    inputPw = inputPw,
                    onValueChange = viewModel::onPwChange
                )
            }

            else -> {
                NicknameView(
                    inputNickname = inputNickname,
                    onValueChange = viewModel::onNicknameChange
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        SignUpButton(
            enabled = if (screenState == SignUpViewModel.Screen.PW) inputPw.isNotEmpty() else inputId.isNotEmpty(),
            onClick = {
                if (screenState == SignUpViewModel.Screen.PW && !isPwValid) {
                    Toast.makeText(context, "유효하지 않은 비밀번호입니다.", Toast.LENGTH_SHORT).show()
                } else if (screenState != SignUpViewModel.Screen.PW && !isIdValid) {
                    Toast.makeText(context, "유효하지 않은 아이디입니다.", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.onScreenChange()
                }
            }
        )
    }
}

@Composable
fun HintText(text: String) {
    Text(
        text = text,
        color = Color.Gray,
        fontSize = 12.sp
    )
}

@Composable
fun IdView(modifier: Modifier = Modifier, inputId: String, onValueChange: (String) -> Unit) {
    Title(
        text = "아이디를 입력해주세요.",
        isCenter = true
    )
    Spacer(modifier = modifier.height(24.dp))
    InputField(
        value = inputId,
        placeholder = "아이디",
        onValueChange = onValueChange
    )
    Spacer(modifier = modifier.height(8.dp))
    HintText(text = "영문 소문자 또는 영문 소문자, 숫자 조합 6~12 자리")
}

@Composable
fun PwView(modifier: Modifier = Modifier, inputPw: String, onValueChange: (String) -> Unit) {
    Title(
        text = "비밀번호를 입력해주세요.",
        isCenter = true
    )
    Spacer(modifier = modifier.height(24.dp))
    InputField(
        value = inputPw,
        placeholder = "비밀번호",
        onValueChange = onValueChange,
        isPassword = true
    )
    Spacer(modifier = modifier.height(8.dp))
    HintText(text = "영문, 숫자, 특수문자(~!@#$$%^&*) 조합 8~15자리")
}

@Composable
fun NicknameView(
    modifier: Modifier = Modifier,
    inputNickname: String,
    onValueChange: (String) -> Unit
) {
    Title(
        text = "닉네임을 입력해주세요.",
        isCenter = true
    )
    Spacer(modifier = modifier.height(24.dp))
    InputField(
        value = inputNickname,
        placeholder = "닉네임",
        onValueChange = onValueChange,
        isPassword = false
    )
    Spacer(modifier = modifier.height(8.dp))
    HintText(text = "한글/영문/숫자만 사용 가능하며 1자 이상 20자 이하")
}
