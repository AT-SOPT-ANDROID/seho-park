package org.sopt.at.feature.my

import android.provider.ContactsContract.CommonDataKinds.Nickname
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.at.core.components.Title
import org.sopt.at.core.components.TobBar


@Composable
fun MyRoute(
    padding: PaddingValues,
    navigateToHome: () -> Unit,
    viewModel: MyViewModel = hiltViewModel()
) {
    val nickname by viewModel.nickname.collectAsState()

    MyScreen(
        padding = padding,
        nickname = nickname
    )
}

@Composable
fun MyScreen(
    padding: PaddingValues,
    nickname: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 32.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TobBar()
        Spacer(modifier = Modifier.height(16.dp))
        Title(
            text = "my page",
            isCenter = true
        )
        Title(
            text = nickname,
            isCenter = true
        )
    }
}