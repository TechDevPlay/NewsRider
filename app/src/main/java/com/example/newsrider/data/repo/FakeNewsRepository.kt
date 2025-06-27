package com.example.newsrider.data.repo

import androidx.compose.ui.res.painterResource
import com.example.newsrider.R
import com.example.newsrider.data.model.Article
import com.example.newsrider.ui.screens.article.ArticleBlock

object FakeNewsRepository {
    fun getArticles(): List<Article> {
        return listOf(
            Article(
                id = 1,
                thumbnail = R.drawable.img_1,
                title = "Real Madrid Wins 15th Champions League Title",
                date = "2 days ago",
                ctg = "Sports",
                content = listOf(
                    ArticleBlock.Title("Real Madrid Wins 15th Champions League Title"),
                    ArticleBlock.Read("8 min"),
                    ArticleBlock.Publisher("By Galaxy"),
                    ArticleBlock.Date("2 days ago"),
                    ArticleBlock.Image(R.drawable.img_1),
                    ArticleBlock.Heading(""),
                    ArticleBlock.Paragraph("London, May 30, 2025 — Real Madrid claimed their record-extending 15th UEFA Champions League trophy after defeating Manchester City 2-1 in a dramatic final at Wembley. Brazilian forward Vinícius Júnior scored the match-winning goal in the 87th minute, capping a thrilling performance by the Spanish giants."),
                    ArticleBlock.Paragraph("Coach Carlo Ancelotti praised the team’s resilience: “They never stop believing. That’s what makes this club special.” Manchester City, despite dominating possession, failed to convert key chances in the second half."),

                    )
            ),
            Article(
                id = 2,
                thumbnail = R.drawable.img_2,
                title = "Business: Global Stocks Surge as Fed Holds Interest Rates",
                date = "4 days ago",
                ctg = "Business",
                content = listOf(
                    ArticleBlock.Title("Business: Global Stocks Surge as Fed Holds Interest Rates"),
                    ArticleBlock.Read("5 min"),
                    ArticleBlock.Publisher("By Galaxy"),
                    ArticleBlock.Date("3 days ago"),
                    ArticleBlock.Image(R.drawable.img_2),
                    ArticleBlock.Heading(""),
                )
            ),
            Article(
                id = 3,
                thumbnail = R.drawable.img_3,
                title = "Tech: OpenAI Unveils GPT-5 With Full Multimodal Capability",
                date = "6 days ago",
                ctg = "Tech",
                content = listOf(
                    ArticleBlock.Title("Tech: OpenAI Unveils GPT-5 With Full Multimodal Capability"),
                    ArticleBlock.Read("6 min"),
                    ArticleBlock.Publisher("By Galaxy"),
                    ArticleBlock.Date("6 days ago"),
                    ArticleBlock.Image(R.drawable.img_3),
                    ArticleBlock.Heading(""),
                )
            ),
            Article(
                id = 4,
                thumbnail = R.drawable.img_4,
                title = "Culture: Venice Biennale 2025 Celebrates Global Voices",
                date = "8 days ago",
                ctg = "Culture",
                content = listOf(
                    ArticleBlock.Title("Culture: Venice Biennale 2025 Celebrates Global Voices"),
                    ArticleBlock.Read("3 min"),
                    ArticleBlock.Publisher("By Galaxy"),
                    ArticleBlock.Date("1 days ago"),
                    ArticleBlock.Image(R.drawable.img_4),
                    ArticleBlock.Heading(""),

                )
            ),
        )
    }
}
