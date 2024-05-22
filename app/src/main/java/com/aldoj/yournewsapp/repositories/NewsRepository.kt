package com.aldoj.yournewsapp.repositories

import android.util.Log
import com.aldoj.yournewsapp.models.NewsResponse
import com.aldoj.yournewsapp.models.NewsResult
import com.aldoj.yournewsapp.models.ResultState
import com.aldoj.yournewsapp.network.NewsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class NewsRepository(private val newsService: NewsService) {
    suspend fun findTopHeadlines() = flow<NewsResult> {
        try {
            val data = newsService.findTopHeadlines().awaitResponse()
            data.body()?.let {
                emit(NewsResult(articles = it.articles, state = ResultState.SUCCESS))
            }
        } catch (e: Exception) {
            emit(NewsResult(state = ResultState.ERROR))
        }
    }.flowOn(Dispatchers.IO)
}