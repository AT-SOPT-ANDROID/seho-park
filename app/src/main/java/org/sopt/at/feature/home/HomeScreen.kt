package org.sopt.at.feature.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeRoute(
    padding: PaddingValues,
    navigateToGallery: () -> Unit,
    navigateToGalleryWithCategory: (String) -> Unit,
    navigateToPost: (Long) -> Unit,
) {
    HomeScreen(
        padding = padding,
        onPostClick = navigateToPost,
    )
}

fun HomeScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    onPostClick: (Long) -> Unit,
) {

}