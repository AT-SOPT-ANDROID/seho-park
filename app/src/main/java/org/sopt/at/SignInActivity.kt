package org.sopt.at

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.components.InputField
import org.sopt.at.components.LoginButton
import org.sopt.at.components.TobBar
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ATSOPTANDROIDTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignInView(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SignInView(
    modifier: Modifier = Modifier
) {
    var loginValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .background(color = Color.Black)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TobBar()
        Spacer(Modifier.height(48.dp))
        Title()
        Spacer(Modifier.height(24.dp))
        InputField(value = loginValue, onValueChange = { loginValue = it }, placeholder = "아이디")
        Spacer(Modifier.height(12.dp))
        InputField(
            value = passwordValue,
            onValueChange = { passwordValue = it },
            placeholder = "비밀번호",
            isPassword = true,
        )
        Spacer(Modifier.height(24.dp))
        LoginButton()
        Spacer(Modifier.height(32.dp))
        AuthFooter()
        Spacer(Modifier.height(32.dp))
        TermsText()
    }
}

@Composable
fun Title() {
    Text(
        text = "TIVING ID 로그인",
        color = Color.White,
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun AuthFooter() {
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


@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    ATSOPTANDROIDTheme {
        SignInView()
    }
}