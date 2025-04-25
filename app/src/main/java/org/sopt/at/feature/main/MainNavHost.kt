package org.sopt.at.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.sopt.at.ui.theme.BasicBlack

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    padding: PaddingValues
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(BasicBlack)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination
        ) {
            homeNavGraph(
                onNavigateToBlockUser = navigator::navigateToBlockUser,
                padding = PaddingValues(),
                navigateToGallery = { navigator.navigateToGallery() },
                navigateToGalleryWithCategory = { navigator.navigateToGallery(category = it) },
                navigateToPost = { navigator.navigateToFindSuhyeonPost(it) }
            )
        }
    }
}