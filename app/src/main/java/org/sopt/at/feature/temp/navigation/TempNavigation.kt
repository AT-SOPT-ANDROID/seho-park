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

fun NavGraphBuilder.shortsNavGraph(
    padding: PaddingValues,
    onNavigateToHome: () -> Unit,
    onNavigateToLive: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToHistory: () -> Unit,
) {
    composable<MainTabRoute.Shorts> {
        TempRoute(
            padding = padding,
            navigateToHome = onNavigateToHome,
            navigateToLive = onNavigateToLive,
            navigateToSearch = onNavigateToSearch,
            navigateToHistory = onNavigateToHistory,
        )
    }
}

fun NavGraphBuilder.liveNavGraph(
    padding: PaddingValues,
    onNavigateToHome: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToHistory: () -> Unit,
    onNavigateToShorts: () -> Unit,
) {
    composable<MainTabRoute.Live> {
        TempRoute(
            padding = padding,
            navigateToHome = onNavigateToHome,
            navigateToSearch = onNavigateToSearch,
            navigateToHistory = onNavigateToHistory,
            navigateToShorts = onNavigateToShorts,
        )
    }
}


fun NavGraphBuilder.searchNavGraph(
    padding: PaddingValues,
    onNavigateToHome: () -> Unit,
    onNavigateToLive: () -> Unit,
    onNavigateToHistory: () -> Unit,
    onNavigateToShorts: () -> Unit,
    ) {
    composable<MainTabRoute.Search> {
        TempRoute(
            padding = padding,
            navigateToHome = onNavigateToHome,
            navigateToLive = onNavigateToLive,
            navigateToHistory = onNavigateToHistory,
            navigateToShorts = onNavigateToShorts,
        )
    }
}


fun NavGraphBuilder.historyNavGraph(
    padding: PaddingValues,
    onNavigateToHome: () -> Unit,
    onNavigateToLive: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToShorts: () -> Unit,
) {
    composable<MainTabRoute.History> {
        TempRoute(
            padding = padding,
            navigateToHome = onNavigateToHome,
            navigateToLive = onNavigateToLive,
            navigateToSearch = onNavigateToSearch,
            navigateToShorts = onNavigateToShorts,
        )
    }
}
