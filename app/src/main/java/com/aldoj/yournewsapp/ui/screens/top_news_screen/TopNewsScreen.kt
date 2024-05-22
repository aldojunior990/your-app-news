package com.aldoj.yournewsapp.ui.screens.top_news_screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.aldoj.yournewsapp.R
import com.aldoj.yournewsapp.models.ResultState
import com.aldoj.yournewsapp.ui.commons.ArticleComponent
import com.aldoj.yournewsapp.ui.commons.ErrorPage
import com.aldoj.yournewsapp.ui.commons.Header
import com.aldoj.yournewsapp.ui.commons.LoadingPage
import com.aldoj.yournewsapp.ui.viewmodels.TopNewsViewModel
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopNewsScreen(viewModel: TopNewsViewModel = koinViewModel(), navController: NavHostController) {

    val articles by viewModel.articles.collectAsState()

    val state =
        rememberPullRefreshState(refreshing = false, onRefresh = {
            viewModel.refreshArticles()
        })

    Scaffold(topBar = {
        Header(title = stringResource(id = R.string.top_news),
            onBack = { navController.popBackStack() })
    }) {
        LoadingPage(modifier = Modifier
            .fillMaxSize()
            .padding(it),
            isLoading = articles.state == ResultState.LOADING,
            content = {
                if (articles.state == ResultState.SUCCESS) {
                    Box(Modifier.fillMaxSize()) {
                        LazyColumn(modifier = Modifier.pullRefresh(state = state)) {
                            items(articles.articles) { article ->
                                ArticleComponent(data = article)
                            }
                        }
                        PullRefreshIndicator(
                            articles.state == ResultState.LOADING, state, Modifier.align(
                                Alignment.TopCenter
                            )
                        )
                    }

                } else if (articles.state == ResultState.ERROR) {
                    Box(Modifier.fillMaxSize()) {
                        ErrorPage(
                            modifier = Modifier
                                .pullRefresh(state = state)
                                .fillMaxSize()
                        )
                        PullRefreshIndicator(
                            articles.state == ResultState.LOADING, state, Modifier.align(
                                Alignment.TopCenter
                            )
                        )
                    }

                }
            })
    }
}