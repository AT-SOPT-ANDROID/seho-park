package org.sopt.at.feature.temp.navigation
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.feature.temp.TempRoute


fun NavController.navigateToShorts() {
    navigate(MainTabRoute.Shorts)
}

fun NavController.navigateToLive() {
    navigate(MainTabRoute.Live)
}

fun NavController.navigateToSearch() {
    navigate(MainTabRoute.Search)
}

fun NavController.navigateToHistory() {
    navigate(MainTabRoute.History)
}

fun NavGraphBuilder.tempNavgraph(
    padding: PaddingValues,
    navigateToGallery: () -> Unit,
    navigateToGalleryWithCategory: (String) -> Unit,
    navigateToPost: (Long) -> Unit
) {
    composable<MainTabRoute.Shorts> {
        TempRoute (
            padding = padding,
            navigateToGallery = navigateToGallery,
            navigateToGalleryWithCategory = navigateToGalleryWithCategory,
            navigateToPost = navigateToPost,
        )
    }
    composable<MainTabRoute.Live> {
        TempRoute (
            padding = padding,
            navigateToGallery = navigateToGallery,
            navigateToGalleryWithCategory = navigateToGalleryWithCategory,
            navigateToPost = navigateToPost,
        )
    }
    composable<MainTabRoute.Search> {
        TempRoute (
            padding = padding,
            navigateToGallery = navigateToGallery,
            navigateToGalleryWithCategory = navigateToGalleryWithCategory,
            navigateToPost = navigateToPost,
        )
    }
    composable<MainTabRoute.History> {
        TempRoute (
            padding = padding,
            navigateToGallery = navigateToGallery,
            navigateToGalleryWithCategory = navigateToGalleryWithCategory,
            navigateToPost = navigateToPost,
        )
    }
}