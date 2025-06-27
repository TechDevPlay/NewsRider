package com.example.newsrider.ui.screens.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsrider.R
import com.example.newsrider.data.repo.FakeNewsRepository
import com.example.newsrider.ui.component.AppTopBar
import com.example.newsrider.ui.component.BulletInfo
import com.example.newsrider.ui.theme.ThemeMainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryDetailsScreen(onBackPressed: () -> Unit, articleId: Int) {
    val article = FakeNewsRepository.getArticles().find { it.id == articleId }
    Scaffold(
        topBar = {
            AppTopBar(
                color = TopAppBarDefaults.topAppBarColors(containerColor = ThemeMainColor),
                onBackPressed = onBackPressed,
                tint = Color.White,
                iconFirst = painterResource(R.drawable.share),
                iconSecond = painterResource(R.drawable.bookmark)
            )
        }
    ) { innerPadding ->
        article?.let {
            Box(modifier = Modifier
                .fillMaxSize().padding(innerPadding)) {
                Box(
                    modifier = Modifier
                        .background(ThemeMainColor)
                        .height(220.dp)
                        .fillMaxWidth()
                ){

                }
                StoryDetailsBody(it.content)
            }
        }
    }
}


@Composable
fun StoryDetailsBody(content: List<ArticleBlock>) {
    val title = content.find { it is ArticleBlock.Title } as? ArticleBlock.Title
    val image = content.find { it is ArticleBlock.Image } as? ArticleBlock.Image
    val read = content.find { it is ArticleBlock.Read } as? ArticleBlock.Read
    val date = content.find { it is ArticleBlock.Date } as? ArticleBlock.Date
    val publisher = content.find { it is ArticleBlock.Publisher } as? ArticleBlock.Publisher

    val contentBlocks = content.filterNot {
        it is ArticleBlock.Title || it is ArticleBlock.Image ||
                it is ArticleBlock.Read || it is ArticleBlock.Date || it is ArticleBlock.Publisher
    }
    Card(modifier = Modifier.fillMaxSize(), shape = RoundedCornerShape(30.dp)) {
        Column(
            modifier = Modifier
                .padding(17.dp)
                .fillMaxSize()
        ) {
            ArticleHeader(title, image)
            Spacer(modifier = Modifier.height(10.dp))
            ArticleMetadata(read, publisher, date)
            Spacer(modifier = Modifier.height(18.dp))
            ArticleContent(contentBlocks)
        }
    }

}
