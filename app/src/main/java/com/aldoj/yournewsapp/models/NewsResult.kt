package com.aldoj.yournewsapp.models

data class NewsResult(
    val articles: List<Article> = listOf(),
    val state: ResultState = ResultState.LOADING
)
