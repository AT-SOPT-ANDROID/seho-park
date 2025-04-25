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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.at.core.type.ContentType
import org.sopt.at.feature.home.components.Banner
import org.sopt.at.feature.home.components.CommonTabBar
import org.sopt.at.feature.home.components.HomeTopBar
import org.sopt.at.feature.home.components.TodayTop20
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
            TodayTop20(viewModel.topList)
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
//        item{
//            Spacer(modifier = Modifier.height(8.dp))
//            ContentsNow(viewModel.contentsList)
//        }
        item {
            Spacer(modifier = modifier.height(50.dp))
        }
    }
}