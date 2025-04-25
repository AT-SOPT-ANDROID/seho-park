package org.sopt.at.feature.temp


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TempRoute(
    padding: PaddingValues,
    navigateToHome: () -> Unit = {},
    navigateToLive: () -> Unit = {},
    navigateToSearch: () -> Unit = {},
    navigateToHistory: () -> Unit = {},
    navigateToShorts: () -> Unit = {},
) {
    TempScreen(
        padding = padding,
        onPostClick = navigateToHome,
    )
}

fun TempScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    onPostClick: () -> Unit,
) {

}