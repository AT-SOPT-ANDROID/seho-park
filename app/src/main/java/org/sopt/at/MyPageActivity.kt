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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sopt.at.components.Title
import org.sopt.at.components.TobBar
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class MyPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val userId = intent.getStringExtra("id") ?: "Unknown"

        setContent {
            ATSOPTANDROIDTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Black,
                ) { innerPadding ->
                    MyPageScreen(
                        modifier = Modifier.padding(innerPadding),
                        name = userId
                    )
                }
            }
        }
    }
}

@Composable
fun MyPageScreen(modifier: Modifier = Modifier, name: String) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 32.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TobBar()
        Spacer(modifier = Modifier.height(16.dp))
        Title(
            text = name,
            isCenter = true
        )
    }
}