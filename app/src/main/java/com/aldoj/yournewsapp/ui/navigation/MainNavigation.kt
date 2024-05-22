package com.aldoj.yournewsapp.ui.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aldoj.yournewsapp.ui.screens.for_you_screen.ForYouScreen
import com.aldoj.yournewsapp.ui.screens.top_news_screen.TopNewsScreen


@Composable
fun MainNavigationGraph(navController: NavHostController) {
    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
        NavHost(navController = navController,
            modifier = Modifier.padding(bottom = it.calculateBottomPadding()),
            route = AppGraph.main.ROOT,
            startDestination = AppGraph.main.FOR_YOU_SCREEN,
            enterTransition = { fadeIn() + slideInHorizontally() }) {
            composable(AppGraph.main.FOR_YOU_SCREEN) {
                ForYouScreen()
            }
            composable(AppGraph.main.TOP_NEWS_SCREEN) {
                TopNewsScreen(navController = navController)
            }
        }
    }

}




