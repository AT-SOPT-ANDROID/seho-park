package org.sopt.at.feature.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.sopt.at.components.InputField
import org.sopt.at.components.LoginButton
import org.sopt.at.components.Title
import org.sopt.at.components.TobBar
import org.sopt.at.ui.theme.BasicBlack


@Composable
fun SignInRoute(
    padding: PaddingValues,
    navigateToSignUp: () -> Unit,
    navigateToHome: (id: String) -> Unit
) {
    var loginValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }

    // SignUp에서 받아온 값이 있다고 가정 (추후 ViewModel에서 처리 가능)
    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }

    SignInScreen(
        modifier = Modifier,
        padding = padding,
        loginValue = loginValue,
        passwordValue = passwordValue,
        onLoginValueChange = { loginValue = it },
        onPasswordValueChange = { passwordValue = it },
        snackbarHostState = snackbarHostState,
        onSignUpClick = navigateToSignUp,
        onLoginSuccess = navigateToHome,
        id = id,
        pw = pw
    )
}
@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    padding: PaddingValues,
    loginValue: String,
    passwordValue: String,
    onLoginValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit,
    onSignUpClick: () -> Unit,
    onLoginSuccess: (String) -> Unit,
    snackbarHostState: SnackbarHostState,
    id: String,
    pw: String,
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BasicBlack)
            .padding(16.dp)
    ) {
        TobBar()
        Spacer(Modifier.height(48.dp))
        Title(text = "TIVING ID 로그인")
        Spacer(Modifier.height(24.dp))
        InputField(value = loginValue, onValueChange = onLoginValueChange, placeholder = "아이디")
        Spacer(Modifier.height(12.dp))
        InputField(
            value = passwordValue,
            onValueChange = onPasswordValueChange,
            placeholder = "비밀번호",
            isPassword = true
        )
        Spacer(Modifier.height(24.dp))
        LoginButton(
            onClick = {
                if (loginValue == id && passwordValue == pw) {
                    onLoginSuccess(loginValue)
                } else {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("아이디 또는 비밀번호가 일치하지 않습니다")
                    }
                }
            },
            isEnabled = loginValue.isNotEmpty() && passwordValue.isNotEmpty()
        )
        Spacer(Modifier.height(32.dp))
        AuthFooter(onSignUpClick = onSignUpClick)
        Spacer(Modifier.height(32.dp))
        TermsText()
    }
}


@Composable
fun AuthFooter(
    onSignUpClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "아이디 찾기",
            color = Color.Gray,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = "|",
            color = Color.Gray,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = "비밀번호 찾기",
            color = Color.Gray,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = "|",
            color = Color.Gray,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            modifier = Modifier.clickable {
                onSignUpClick()
            },
            text = "회원가입",
            color = Color.Gray,
        )
    }
}

@Composable
fun TermsText(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        lineHeight = 20.sp,
        color = Color.Gray,
        text = buildAnnotatedString {
            append("이 사이트는 Google reCAPTCHA로 보호되며,\n")

            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append("Google 개인정보 처리방침")
            }

            append("과 ")

            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append("서비스 약관")
            }

            append("이 적용됩니다.")
        },
    )
}