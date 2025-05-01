package org.sopt.at.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.signin.SignInRoute


fun NavController.navigateToSignIn() {
    navigate(Route.SignIn)
}


fun NavGraphBuilder.signInNavGraph(
    padding: PaddingValues,
    onNavigateToSignUp: () -> Unit,
    onNavigateToHome: () -> Unit,
) {
    composable<Route.SignIn> {
        SignInRoute(
            padding = padding,
            navigateToSignUp = onNavigateToSignUp,
            navigateToHome = onNavigateToHome,
        )
    }
}