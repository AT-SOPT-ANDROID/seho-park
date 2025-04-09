package org.sopt.at

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(16.dp, 16.dp)
    ) {
        TobBar()
        Spacer(Modifier.height(32.dp))
        Title()
        Spacer(Modifier.height(16.dp))
        InputField(value = loginValue, onValueChange = { loginValue = it }, placeholder = "아이디")
        Spacer(Modifier.height(8.dp))
        InputField(
            value = passwordValue,
            onValueChange = { passwordValue = it },
            placeholder = "비밀번호",
            isPassword = true,
        )
        Spacer(Modifier.height(16.dp))
        LoginButton()
    }
}

@Composable
fun Title() {
    Text(
        text = "TIVING ID 로그인",
        color = Color.White,
        fontSize = 24.sp,
    )
}



@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    ATSOPTANDROIDTheme {
        SignInView()
    }
}