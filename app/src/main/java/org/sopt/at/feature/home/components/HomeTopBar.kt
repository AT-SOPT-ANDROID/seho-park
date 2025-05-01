package org.sopt.at.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.R
import org.sopt.at.ui.theme.BasicBlack
import org.sopt.at.ui.theme.BasicWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    navigateToMy: () -> Unit
) {
    TopAppBar(
        title = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.tiving),
                contentDescription = stringResource(R.string.app_name),
                tint = Color.Unspecified,
                modifier = Modifier.height(56.dp)
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.ic_connect),
                    contentDescription = "connect",
                    tint = BasicWhite,
                    modifier = Modifier.size(28.dp)
                )
            }
            IconButton(onClick = navigateToMy) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "profile",
                    modifier = Modifier.size(28.dp)
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = BasicBlack,
            titleContentColor = BasicWhite
        ),
    )
}


@Composable
@Preview
fun TvingTobBar() {
    HomeTopBar(
        navigateToMy = {}
    )
}