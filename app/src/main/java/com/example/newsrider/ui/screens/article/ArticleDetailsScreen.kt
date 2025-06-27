package com.example.newsrider.ui.screens.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsrider.R
import com.example.newsrider.data.repo.FakeNewsRepository
import com.example.newsrider.ui.component.AppTopBar
import com.example.newsrider.ui.component.BulletInfo
import com.example.newsrider.ui.theme.ThemeMainColor

sealed class ArticleBlock {
    data class Title(val text: String) : ArticleBlock()
    data class Date(val text: String) : ArticleBlock()
    data class Publisher(val text: String) : ArticleBlock()
    data class Read(val text: String) : ArticleBlock()
    data class Heading(val text: String) : ArticleBlock()
    data class Paragraph(val text: String) : ArticleBlock()
    data class Image(val painter: Int) : ArticleBlock()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailsScreen(onBackPressed:()->Unit, articleId:Int){
    val article = FakeNewsRepository.getArticles().find { it.id == articleId }
    Scaffold(
        topBar = {
            AppTopBar(
                color = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
                onBackPressed = onBackPressed,
                tint = ThemeMainColor,
                iconFirst = painterResource(R.drawable.share),
                iconSecond = painterResource(R.drawable.bookmark)
            )
        }
    ) { innerPadding ->
        Box(modifier=Modifier.fillMaxSize().padding(innerPadding)){
            article?.let {
                ArticleDetailsBody(it.content)
            }
        }
    }
}

@Composable
fun ArticleDetailsBody(content: List<ArticleBlock>) {
    val title = content.find { it is ArticleBlock.Title } as? ArticleBlock.Title
    val image = content.find { it is ArticleBlock.Image } as? ArticleBlock.Image
    val read = content.find { it is ArticleBlock.Read } as? ArticleBlock.Read
    val date = content.find { it is ArticleBlock.Date } as? ArticleBlock.Date
    val publisher = content.find { it is ArticleBlock.Publisher } as? ArticleBlock.Publisher

    val contentBlocks = content.filterNot {
        it is ArticleBlock.Title || it is ArticleBlock.Image ||
                it is ArticleBlock.Read || it is ArticleBlock.Date || it is ArticleBlock.Publisher
    }
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(17.dp)) {
        ArticleHeader(title, image)
        Spacer(modifier = Modifier.height(7.dp))
        ArticleMetadata(read, publisher, date)
        ArticleContent(contentBlocks)
    }
}

@Composable
fun ArticleHeader(title: ArticleBlock.Title?, image: ArticleBlock.Image?) {
    image?.let {
        Image(
            painter = painterResource(it.painter),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier=Modifier.height(12.dp))
    }
    title?.let {
        Text(
            text = it.text,
            lineHeight = 26.sp,
            fontSize = 28.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun ArticleMetadata(
    read: ArticleBlock.Read?,
    publisher: ArticleBlock.Publisher?,
    date: ArticleBlock.Date?
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        read?.let { BulletInfo(it.text) }
        publisher?.let { BulletInfo(it.text) }
        date?.let { BulletInfo(it.text) }
    }
}

@Composable
fun ArticleContent(content: List<ArticleBlock>) {
    Column {
        content.forEach { content ->
            when (content) {
                is ArticleBlock.Heading -> Text(
                    content.text,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                is ArticleBlock.Paragraph -> Text(
                    content.text,
                    fontSize = 16.sp,
                    lineHeight = 22.sp
                )

                is ArticleBlock.Image -> Image(
                    painter = painterResource(content.painter),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(12.dp))
                )

                else -> Unit
            }
        }
    }
}

@Preview
@Composable
fun AppPreview(){
    ArticleDetailsScreen(onBackPressed = {}, articleId = 2)
}