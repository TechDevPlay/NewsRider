package com.example.newsrider.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsrider.R
import com.example.newsrider.data.model.Article
import com.example.newsrider.ui.component.AppTopBar
import com.example.newsrider.ui.component.BulletInfo
import com.example.newsrider.ui.theme.ThemeMainColor

@Composable
fun StoryCard(article: Article, onNewsClick:(Int)->Unit) {

    Box(modifier=Modifier.width(152.dp).height(187.dp).clip(RoundedCornerShape(15.dp)).clickable { onNewsClick(article.id) }) {
        Image(
            painter = painterResource(article.thumbnail),
            contentDescription = article.title,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(15.dp))
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.9f)
                        ),
                        startY = 100f, // adjust this value as needed
                        endY = Float.POSITIVE_INFINITY
                    )
                )
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(9.dp).align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = article.title,
                    fontSize = 14.sp,
                    color = Color.White,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.W600
                )
                BulletInfo(article.date)
            }
        }
    }
}
