package com.example.newsrider.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsrider.R
import com.example.newsrider.data.model.Article
import com.example.newsrider.ui.component.BulletInfo
import com.example.newsrider.ui.theme.ThemeMainColor

//News Card for Top News

@Composable
fun TopNewsCard(article: Article, onNewsClick:(Int)->Unit) {
    Column(modifier = Modifier.width(210.dp).wrapContentHeight().clickable { onNewsClick(article.id) }) {
        Image(
            painter = painterResource(article.thumbnail),
            contentDescription = article.title,
            modifier = Modifier.clip(shape = RoundedCornerShape(15.dp)).width(210.dp).height(140.dp)
        )
        Spacer(modifier= Modifier.height(5.dp))
        Column(modifier=Modifier.padding(horizontal = 4.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = article.ctg,
                    fontSize = 13.sp,
                    color = ThemeMainColor,
                    fontWeight = FontWeight.W600
                )
                Spacer(modifier = Modifier.weight(1f))
                BulletInfo(article.date)
            }
            Text(
                text = article.title,
                fontSize = 14.sp,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.W600
            )
        }

    }
}
