package org.sopt.at.feature.my

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sopt.at.components.Title
import org.sopt.at.components.TobBar
import org.sopt.at.core.navigation.Route


@Composable
fun MyRoute(
    padding: PaddingValues,
    navigateToHome: () -> Unit,
) {
    MyScreen(
        padding = padding,
        onPostClick = navigateToHome,
    )
}

@Composable
fun MyScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    onPostClick: () -> Unit,
) {
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
            text = "my page",
            isCenter = true
        )
    }
}