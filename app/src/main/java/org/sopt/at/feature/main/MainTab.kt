package org.sopt.at.feature.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import org.sopt.at.R
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.core.navigation.Route

enum class MainTab(
    @DrawableRes val defaultIconResId: Int,
    @DrawableRes val selectIconResId: Int,
    @StringRes val descriptionResId: Int,
    val route: MainTabRoute,
) {
    HOME(
        defaultIconResId = R.drawable.ic_home_default,
        selectIconResId =  R.drawable.ic_home_select,
        descriptionResId = R.string.bottom_navigation_bar_item_home,
        route = MainTabRoute.HomeTab,
    ),
    SHORTS(
        defaultIconResId = R.drawable.ic_find_suhyeon_default,
        selectIconResId =  R.drawable.ic_find_suhyeon_select,
        descriptionResId = R.string.bottom_navigation_bar_item_find_suhyeon,
        MainTabRoute.ShortsTab
    ),
    LIVE(
        defaultIconResId = R.drawable.ic_gallery_default,
        selectIconResId =  R.drawable.ic_gallery_select,
        descriptionResId = R.string.bottom_navigation_bar_item_gallery,
        MainTabRoute.LiveTab
    ),
    SEARCH(
        defaultIconResId = R.drawable.ic_chat_default,
        selectIconResId =  R.drawable.ic_chat_select,
        descriptionResId = R.string.bottom_navigation_bar_item_chat,
        MainTabRoute.SearchTab
    ),
    HISTORY(
        defaultIconResId = R.drawable.ic_my_default,
        selectIconResId =  R.drawable.ic_my_select,
        descriptionResId = R.string.bottom_navigation_bar_item_my,
        MainTabRoute.HistoryTab,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}