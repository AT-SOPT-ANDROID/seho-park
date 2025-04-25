package org.sopt.at.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.at.ui.theme.BasicBlack
import org.sopt.at.ui.theme.BasicWhite

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

@Composable
fun HomeScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    onPostClick: () -> Unit,
) {

}