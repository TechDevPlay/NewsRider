package com.example.newsrider.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newsrider.R
import com.example.newsrider.data.repo.FakeNewsRepository
import com.example.newsrider.ui.cards.EarliestNewsCard
import com.example.newsrider.ui.cards.StoryCard
import com.example.newsrider.ui.cards.TopNewsCard
import com.example.newsrider.ui.component.AppTopBar
import com.example.newsrider.ui.component.SearchBar
import com.example.newsrider.ui.component.SectionHeader
import com.example.newsrider.ui.screens.article.ArticleHeader
import com.example.newsrider.ui.theme.ThemeMainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onArticleClick: (Int) -> Unit, onStoryClick: (Int) -> Unit) {
    val articles = FakeNewsRepository.getArticles()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo), // your logo
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .size(180.dp),
                    )
                },
                actions = {
                    IconButton(
                        onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(containerColor = ThemeMainColor),
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.dark_mode),
                            contentDescription = "Filter Icon",
                            tint = Color.White
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
        ) {
            item {
                SearchBar()
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))

                SectionHeader(heading = "Top News", onClick = {})
                Spacer(modifier = Modifier.height(15.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(articles) { article ->
                        TopNewsCard(
                            article = article,
                            onNewsClick = { onArticleClick(article.id) }
                        )
                    }
                }

            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                ) {
                    SectionHeader(heading = "Stories", onClick = {})
                    Spacer(modifier = Modifier.height(15.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(articles) { article ->
                            StoryCard(
                                article = article,
                                onNewsClick = { onStoryClick(article.id) }
                            )
                        }
                    }
                }

            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                SectionHeader(heading = "Earliest News", onClick = {})
                Spacer(modifier = Modifier.height(15.dp))

            }
            items(articles) { article ->
                EarliestNewsCard(
                    article = article,
                    onNewsClick = { onArticleClick(article.id) }
                )
            }
        }
    }
}