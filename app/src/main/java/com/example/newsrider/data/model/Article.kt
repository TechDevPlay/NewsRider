package com.example.newsrider.data.model

import androidx.compose.ui.graphics.painter.Painter
import com.example.newsrider.ui.screens.article.ArticleBlock

data class Article(
    val id: Int,
    val thumbnail: Int,
    val title: String,
    val date:String,
    val ctg:String,
    val content: List<ArticleBlock>
)

