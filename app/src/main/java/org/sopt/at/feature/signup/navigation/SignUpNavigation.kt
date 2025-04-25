package org.sopt.at.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.signup.SignUpRoute


fun NavController.navigateToSignUp() {
    navigate(Route.SignUp)
}

fun NavGraphBuilder.signUpNavGraph(
    padding: PaddingValues,
    onNavigateToSignIn: () -> Unit,
) {
    composable<MainTabRoute.Home> {
        SignUpRoute (
            padding = padding,
            navigateToSignIn = onNavigateToSignIn
        )
    }
}