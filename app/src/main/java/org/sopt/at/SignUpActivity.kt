package org.sopt.at

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.components.InputField
import org.sopt.at.components.SignUpButton
import org.sopt.at.components.Title
import org.sopt.at.components.TobBar
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ATSOPTANDROIDTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Black,
                ) { innerPadding ->
                    SignUpScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = AuthViewModel(),
                        onNavigateToSignIn = {
                            startActivity(Intent(this, SignInActivity::class.java))
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(
    modifier: Modifier, viewModel: AuthViewModel, onNavigateToSignIn: () -> Unit
) {
    var inputId = viewModel.inputId
    var inputPw = viewModel.inputPw
    val isIdValid = viewModel.isIdValid
    val isPwValid = viewModel.isPwValid
    val isPasswdScreen = viewModel.isPasswordScreen
    val navigateToSignIn by viewModel.navigateToSignIn.collectAsState()

    LaunchedEffect(navigateToSignIn) {
        if (navigateToSignIn) {
            onNavigateToSignIn()
            viewModel.onNavigated()
        }
    }
    Column(
        modifier = modifier
            .background(color = Color.Black)
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 32.dp, start = 16.dp, end = 16.dp),
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
        Spacer(modifier = modifier.weight(1f))
        SignUpButton(
            enabled = if (isPasswdScreen) isPwValid else isIdValid,
            onClick = viewModel::onScreenChange
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


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ATSOPTANDROIDTheme {
//        SignUpScreen(modifier = Modifier, viewModel = SignUpViewModel())
//    }
//}