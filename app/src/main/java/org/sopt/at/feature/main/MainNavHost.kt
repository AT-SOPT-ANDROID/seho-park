package org.sopt.at.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import org.sopt.at.feature.home.navigation.homeNavGraph
import org.sopt.at.feature.home.navigation.myNavGraph
import org.sopt.at.feature.home.navigation.signInNavGraph
import org.sopt.at.feature.home.navigation.signUpNavGraph
import org.sopt.at.feature.temp.navigation.historyNavGraph
import org.sopt.at.feature.temp.navigation.liveNavGraph
import org.sopt.at.feature.temp.navigation.searchNavGraph
import org.sopt.at.feature.temp.navigation.shortsNavGraph
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
//            .background(BasicBlack)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination
        ) {
            homeNavGraph(
                padding = PaddingValues(
                    start = padding.calculateStartPadding(layoutDirection = LayoutDirection.Ltr),
                    end = padding.calculateEndPadding(layoutDirection = LayoutDirection.Ltr),
                    bottom = padding.calculateBottomPadding(),
                    top = 0.dp
                ),
                onNavigateToShorts = navigator::navigateToShorts,
                onNavigateToSearch = navigator::navigateToSearch,
                onNavigateToLive = navigator::navigateToLive,
                onNavigateToHistory = navigator::navigateToHistory,
                onNavigateToMy = navigator::navigateToMy,
            )
            signInNavGraph(
                padding = padding,
                onNavigateToSignUp = navigator::navigateToSignUp,
                onNavigateToHome = navigator::navigateToHome
            )
            signUpNavGraph(
                padding = padding,
                onNavigateToSignIn = navigator::navigateToSignIn,
            )
            shortsNavGraph(
                padding = padding,
                onNavigateToHome = navigator::navigateToHome,
                onNavigateToLive = navigator::navigateToLive,
                onNavigateToSearch = navigator::navigateToSearch,
                onNavigateToHistory = navigator::navigateToHistory,

                )
            liveNavGraph(
                padding = padding,
                onNavigateToHome = navigator::navigateToHome,
                onNavigateToShorts = navigator::navigateToShorts,
                onNavigateToSearch = navigator::navigateToSearch,
                onNavigateToHistory = navigator::navigateToHistory,
            )
            searchNavGraph(
                padding = padding,
                onNavigateToHome = navigator::navigateToHome,
                onNavigateToShorts = navigator::navigateToShorts,
                onNavigateToLive = navigator::navigateToLive,
                onNavigateToHistory = navigator::navigateToHistory,
            )
            historyNavGraph(
                padding = padding,
                onNavigateToHome = navigator::navigateToHome,
                onNavigateToShorts = navigator::navigateToShorts,
                onNavigateToSearch = navigator::navigateToSearch,
                onNavigateToLive = navigator::navigateToLive,
            )
            myNavGraph(
                padding = padding,
                onNavigateToHome = navigator::navigateToHome,
            )
        }
    }
}