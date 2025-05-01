package org.sopt.at.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.my.MyRoute


fun NavController.navigateToMy() {
    navigate(Route.My)
}


fun NavGraphBuilder.myNavGraph(
    padding: PaddingValues,
    onNavigateToHome: () -> Unit,
) {
    composable<Route.My> {
        MyRoute(
            padding = padding,
            navigateToHome = onNavigateToHome,
        )
    }
}