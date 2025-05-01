package org.sopt.at.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.core.extension.noRippleClickable
import org.sopt.at.core.type.ContentType
import org.sopt.at.ui.theme.BasicBlack
import org.sopt.at.ui.theme.BasicWhite
import org.sopt.at.ui.theme.Gray03

@Composable
fun CommonTabBar(
    selectedContentType: ContentType?,
    onContentTypeSelected: (ContentType) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth()
            .background(BasicBlack)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ContentType.entries.forEach { contentType ->
            val isSelected = contentType == selectedContentType
            Text(
                modifier = Modifier
                    .noRippleClickable(onClick = { onContentTypeSelected(contentType) }),
                text = stringResource(contentType.titleResId),
                fontSize = 18.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) BasicWhite else Gray03
            )
        }
    }
}

@Preview
@Composable
fun PreviewCommonTabBar() {
    CommonTabBar(
        selectedContentType = ContentType.DRAMA,
        onContentTypeSelected = {}
    )
}
