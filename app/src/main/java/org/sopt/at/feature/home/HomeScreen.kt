package org.sopt.at.feature.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeRoute(
    padding: PaddingValues,
    navigateToShorts: () -> Unit,
    navigateToSearch: () -> Unit,
    navigateToLive: () -> Unit,
    navigateToHistory: () -> Unit,
    navigateToMy: () -> Unit,
) {
    HomeScreen(
        padding = padding,
        onPostClick = navigateToHistory,
    )
}

fun HomeScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    onPostClick: () -> Unit,
) {

}