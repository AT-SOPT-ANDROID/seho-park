package org.sopt.at.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.home.navigation.navigateToHome
import org.sopt.at.feature.home.navigation.navigateToMy
import org.sopt.at.feature.home.navigation.navigateToSignIn
import org.sopt.at.feature.home.navigation.navigateToSignUp
import org.sopt.at.feature.temp.navigation.navigateToHistory
import org.sopt.at.feature.temp.navigation.navigateToLive
import org.sopt.at.feature.temp.navigation.navigateToSearch
import org.sopt.at.feature.temp.navigation.navigateToShorts

class MainNavigator(
    val navController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = Route.SignIn

    val currentTab: MainTab?
        @Composable get() = MainTab.entries.find { tab ->
            currentDestination?.route == tab.route::class.qualifiedName
        }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(MainTab.HOME.route) {
                inclusive = false
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.HOME -> navController.navigateToHome(navOptions)
            MainTab.SHORTS -> navController.navigateToShorts()
            MainTab.LIVE -> navController.navigateToLive()
            MainTab.SEARCH -> navController.navigateToSearch()
            MainTab.HISTORY -> navController.navigateToHistory()
        }
    }

    fun navigateToHome(navOptions: NavOptions? = null) {
        navController.navigateToHome(
            navOptions ?: navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        )
    }
    fun navigateToShorts() {
        navController.navigateToShorts()
    }
    fun navigateToLive() {
        navController.navigateToLive()
    }
    fun navigateToSearch() {
        navController.navigateToSearch()
    }
    fun navigateToHistory() {
        navController.navigateToHistory()
    }
    fun navigateToMy() {
        navController.navigateToMy()
    }
    fun navigateToSignIn(userId: String, pw: String) {
        navController.navigateToSignIn()
    }
    fun navigateToSignUp() {
        navController.navigateToSignUp()
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}