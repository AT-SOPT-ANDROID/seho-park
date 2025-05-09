package org.sopt.at.core.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import org.sopt.at.R

@Composable
fun TobBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "뒤로가기",
            tint = Color.White
        )
    }
}