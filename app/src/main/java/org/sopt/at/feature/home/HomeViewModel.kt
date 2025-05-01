package org.sopt.at.feature.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.at.R
import org.sopt.at.core.model.Top20
import org.sopt.at.feature.home.model.ContentItem
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    val banners: ImmutableList<Int> = persistentListOf(
        R.drawable.banner1,
        R.drawable.banner1,
    )

    val topList: ImmutableList<Top20> = persistentListOf(
        Top20(1, R.drawable.top1),
        Top20(2, R.drawable.top2),
        Top20(3, R.drawable.top1),
        Top20(4, R.drawable.top2),
    )


    val contentsList: ImmutableList<ContentItem> = persistentListOf(
        ContentItem(1, R.drawable.now1),
        ContentItem(2, R.drawable.now2),
        ContentItem(3, R.drawable.now3),
        ContentItem(4, R.drawable.now1),
        ContentItem(5, R.drawable.now2),
        ContentItem(6, R.drawable.now3),
    )
}