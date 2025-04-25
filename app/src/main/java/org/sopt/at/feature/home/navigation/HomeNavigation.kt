package org.sopt.at.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.feature.home.HomeRoute


fun NavController.navigateToHome(navOptions: NavOptions) {
    navigate(MainTabRoute.Home, navOptions)
}


fun NavGraphBuilder.homeNavGraph(
    padding: PaddingValues,
    onNavigateToShorts: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToLive: () -> Unit,
    onNavigateToHistory: () -> Unit,
    onNavigateToMy: () -> Unit,
) {
    composable<MainTabRoute.Home> {
        HomeRoute(
            padding = padding,
            navigateToShorts = onNavigateToShorts,
            navigateToSearch = onNavigateToSearch,
            navigateToLive = onNavigateToLive,
            navigateToHistory = onNavigateToHistory,
            navigateToMy = onNavigateToMy
        )
    }
}