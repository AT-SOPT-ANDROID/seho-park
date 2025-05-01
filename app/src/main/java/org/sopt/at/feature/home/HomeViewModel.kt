package org.sopt.at.feature.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.at.R
import org.sopt.at.core.model.Top20
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    val banners = listOf(
        R.drawable.banner1,
        R.drawable.banner1,
    )

    val topList = listOf(
        Top20(1, R.drawable.top1),
        Top20(2, R.drawable.top2),
        Top20(3, R.drawable.top1),
        Top20(4, R.drawable.top2),
    )

    val contentsList = listOf(
        R.drawable.now1,
        R.drawable.now2,
        R.drawable.now3,
        R.drawable.now1,
        R.drawable.now2,
        R.drawable.now3,
    )
}