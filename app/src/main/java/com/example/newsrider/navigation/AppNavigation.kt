package com.example.newsrider.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsrider.ui.screens.article.ArticleContent
import com.example.newsrider.ui.screens.article.ArticleDetailsScreen
import com.example.newsrider.ui.screens.article.StoryDetailsScreen
import com.example.newsrider.ui.screens.home.HomeScreen
import com.example.newsrider.ui.screens.splash.SplashScreen

@Composable
fun AppNavigation(modifier: Modifier){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.Splash.route,
    ) {
        composable(Destination.Splash.route) {
            SplashScreen(navController)
        }


        composable(route = Destination.ArticleDetails.route,
            arguments = listOf(navArgument(Destination.ArticleDetails.ARG_NEWS_ID){
                type = NavType.IntType
            })
        ){backStackEntry ->
            val newsId = backStackEntry.arguments?.getInt(Destination.ArticleDetails.ARG_NEWS_ID)
            newsId?.let {
                ArticleDetailsScreen(articleId = it, onBackPressed = {navController.popBackStack()})
            }
        }

        composable(route = Destination.StoryDetails.route,
            arguments = listOf(navArgument(Destination.StoryDetails.ARG_NEWS_ID){
                type = NavType.IntType
            })
        ){backStackEntry ->
            val newsId = backStackEntry.arguments?.getInt(Destination.StoryDetails.ARG_NEWS_ID)
            newsId?.let {
                StoryDetailsScreen(articleId = it, onBackPressed = {navController.popBackStack()})
            }
        }

        composable(Destination.Home.route){
            HomeScreen(onArticleClick = {newsId->
            navController.navigate(Destination.ArticleDetails.routeDetails(newsId))
            }, onStoryClick = {newsId->
                    navController.navigate(Destination.StoryDetails.routeDetails(newsId))
            })
        }

    }
}