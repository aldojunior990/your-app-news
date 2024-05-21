package com.aldoj.yournewsapp.ui.screens.top_news_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.aldoj.yournewsapp.R
import com.aldoj.yournewsapp.ui.commons.Header
import com.aldoj.yournewsapp.ui.viewmodels.TopNewsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun TopNewsScreen(viewModel: TopNewsViewModel = koinViewModel(), navController: NavHostController) {
    Scaffold(topBar = { Header(title = stringResource(id = R.string.top_news)) }) {
        Column(modifier = Modifier.padding(it)) {
        }
    }
}