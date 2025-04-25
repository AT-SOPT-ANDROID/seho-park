package org.sopt.at.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.at.core.type.ContentType
import org.sopt.at.feature.home.components.Banner
import org.sopt.at.feature.home.components.CommonTabBar
import org.sopt.at.feature.home.components.HomeTopBar


@Composable
fun HomeRoute(
    padding: PaddingValues,
    navigateToShorts: () -> Unit,
    navigateToSearch: () -> Unit,
    navigateToLive: () -> Unit,
    navigateToHistory: () -> Unit,
    navigateToMy: () -> Unit,
) {

    HomeScreen(
        padding = padding,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    val viewModel: HomeViewModel = viewModel()
    LazyColumn(
        modifier = modifier.padding(padding),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HomeTopBar()
        }
        stickyHeader {
            CommonTabBar(
                selectedContentType = ContentType.DRAMA,
                onContentTypeSelected = {}
            )
        }
        item {
            Banner(
                banners = viewModel.banners
            )
        }
    }
}