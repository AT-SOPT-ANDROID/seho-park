package org.sopt.at

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(16.dp, 16.dp)
    ) {
        TobBar()
        Spacer(modifier.height(32.dp))
        Title()
        Spacer(modifier.height(16.dp))
        InputField(isLogin = true)
        Spacer(modifier.height(8.dp))
        InputField()
        Spacer(modifier.height(16.dp))
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

@Composable
fun InputField(
    isLogin: Boolean = false
) {
    var loginValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.fillMaxWidth().background(color = Color.Gray),
        value = if (isLogin) {
            loginValue
        } else {
            passwordValue
        },
        onValueChange = if (isLogin) {
            { loginValue = it }
        } else {
            { passwordValue = it }
        },
        visualTransformation = if(isLogin) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
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