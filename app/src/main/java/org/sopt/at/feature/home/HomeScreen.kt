package org.sopt.at.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.collections.immutable.ImmutableList
import org.sopt.at.core.model.Top20
import org.sopt.at.core.type.ContentType
import org.sopt.at.feature.home.components.Banner
import org.sopt.at.feature.home.components.CommonTabBar
import org.sopt.at.feature.home.components.ContentsNow
import org.sopt.at.feature.home.components.HomeTopBar
import org.sopt.at.feature.home.components.TodayTop20
import org.sopt.at.feature.home.model.ContentItem
import org.sopt.at.ui.theme.BasicWhite
import org.sopt.at.ui.theme.TivingTheme.typography


@Composable
fun HomeRoute(
    padding: PaddingValues,
    navigateToShorts: () -> Unit,
    navigateToSearch: () -> Unit,
    navigateToLive: () -> Unit,
    navigateToHistory: () -> Unit,
    navigateToMy: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        padding = padding,
        navigateToMy = navigateToMy,
        banners = viewModel.banners,
        topList = viewModel.topList,
        contentsList = viewModel.contentsList
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    navigateToMy: () -> Unit,
    banners: ImmutableList<Int>,
    topList: ImmutableList<Top20>,
    contentsList: ImmutableList<ContentItem>
) {
    var selectedTab by remember { mutableStateOf(ContentType.DRAMA) }

    LazyColumn(
        modifier = modifier.padding(padding),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            HomeTopBar(
                navigateToMy = navigateToMy
            )
        }
        stickyHeader {
            CommonTabBar(
                selectedContentType = selectedTab,
                onContentTypeSelected = { selectedTab = it }
            )
        }
        item {
            Banner(
                banners = banners
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "오늘의 티빙 TOP 20",
                color = BasicWhite,
                style = typography.subTitle,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        item {
            TodayTop20(topList)
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "지금 방영 중인 콘텐츠",
                color = BasicWhite,
                style = typography.subTitle,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        item {
            ContentsNow(contentsList)
        }
    }
}