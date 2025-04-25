package org.sopt.at.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.core.model.Top20
import org.sopt.at.ui.theme.BasicWhite

@Composable
fun TodayTop20(topList: List<Top20>) {

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(topList) { topItem ->
            Row (
                horizontalArrangement = Arrangement.spacedBy(0.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = topItem.rank.toString(),
                    fontSize = 64.sp,
                    color = BasicWhite,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(id = topItem.imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .height(142.dp)
                        .width(104.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }
    }
}