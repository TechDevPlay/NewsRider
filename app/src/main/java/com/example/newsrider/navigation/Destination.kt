package com.example.newsrider.navigation

sealed class Destination(val route:String) {
    object Splash: Destination("splash")
    object Home: Destination("home")
    object ArticleDetails : Destination("articleDetails/{newsId}") {
        fun routeDetails(newsId: Int) = "articleDetails/$newsId"
        const val ARG_NEWS_ID = "newsId"
    }
    object StoryDetails : Destination("storyDetails/{newsId}") {
        fun routeDetails(newsId: Int) = "storyDetails/$newsId"
        const val ARG_NEWS_ID = "newsId"
    }
}