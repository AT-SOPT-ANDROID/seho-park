package org.sopt.at.core.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginButton(modifier: Modifier = Modifier, isEnabled: Boolean = false, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
        onClick = onClick,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF153C),
            disabledContainerColor = Color(0xFF2C2C2C),
        ),
        shape = RoundedCornerShape(4.dp)

    ) {
        Text(
            text = "로그인하기",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = if (isEnabled) Color.White else Color.Gray
        )
    }
}

@Composable
fun SignUpButton(modifier: Modifier = Modifier, enabled: Boolean = false, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(4.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
        ),
        enabled = enabled,
        onClick = onClick
    ) {
        Text(text = "다음", color = Color.White)
    }
}