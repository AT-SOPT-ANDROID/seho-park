package org.sopt.at.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.home.HomeRoute


fun NavController.navigateToSignIn() {
    navigate(Route.SignIn)
}


fun NavGraphBuilder.signInNavgraph(
    padding: PaddingValues,
    navigateToGallery: () -> Unit,
    navigateToGalleryWithCategory: (String) -> Unit,
    navigateToPost: (Long) -> Unit
) {
    composable<MainTabRoute.Home> {
        HomeRoute(
            padding = padding,
            navigateToGallery = navigateToGallery,
            navigateToGalleryWithCategory = navigateToGalleryWithCategory,
            navigateToPost = navigateToPost,
        )
    }
}