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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.at.core.components.InputField
import org.sopt.at.core.components.SignUpButton
import org.sopt.at.core.components.Title
import org.sopt.at.core.components.TobBar
import org.sopt.at.ui.theme.BasicBlack


@Composable
fun SignUpRoute(
    padding: PaddingValues,
    navigateToSignIn: (id: String, pw: String) -> Unit
) {
    val viewModel: AuthViewModel = viewModel()

    SignUpScreen(
        padding = padding,
        modifier = Modifier,
        viewModel = viewModel,
        navigateToSignIn = navigateToSignIn
    )
}

@Composable
fun SignUpScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel,
    navigateToSignIn: (id: String, pw: String) -> Unit,
) {
    val inputId = viewModel.inputId
    val inputPw = viewModel.inputPw
    val isIdValid = viewModel.isIdValid
    val isPwValid = viewModel.isPwValid
    val isPasswdScreen = viewModel.isPasswordScreen

    val context = LocalContext.current

//    LaunchedEffect(navigateToSignInState) {
//        if (navigateToSignInState) {
//            navigateToSignIn(inputId, inputPw)
//            viewModel.onNavigated()
//        }
//    }

    Column(
        modifier = modifier
            .background(BasicBlack)
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp)
    ) {
        TobBar()
        Spacer(modifier = Modifier.height(16.dp))
        if (!isPasswdScreen) {
            IdView(
                inputId = inputId,
                onValueChange = viewModel::onIdChange
            )
        } else {
            PwView(
                inputPw = inputPw,
                onValueChange = viewModel::onPwChange
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        SignUpButton(
            enabled = if (isPasswdScreen) inputPw.isNotEmpty() else inputId.isNotEmpty(),
            onClick = {
                if (isPasswdScreen && !isPwValid) {
                    Toast.makeText(context, "유효하지 않은 비밀번호입니다.", Toast.LENGTH_SHORT).show()
                } else if (!isPasswdScreen && !isIdValid) {
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
