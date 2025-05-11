package org.sopt.at.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Title(
    text: String,
    isCenter: Boolean = false
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text,
        color = Color.White,
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = if (isCenter) TextAlign.Center else TextAlign.Left
    )
}