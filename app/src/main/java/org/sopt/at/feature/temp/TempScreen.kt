package org.sopt.at.feature.temp


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TempRoute(
    padding: PaddingValues,
    navigateToGallery: () -> Unit,
    navigateToGalleryWithCategory: (String) -> Unit,
    navigateToPost: (Long) -> Unit,
) {
    TempScreen(
        padding = padding,
        onPostClick = navigateToPost,
    )
}

fun TempScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    onPostClick: (Long) -> Unit,
) {

}