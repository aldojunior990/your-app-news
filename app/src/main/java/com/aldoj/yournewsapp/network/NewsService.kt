package com.aldoj.yournewsapp.network

import com.aldoj.yournewsapp.BuildConfig
import com.aldoj.yournewsapp.models.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("everything?q={theme}&apiKey={api_key}")
    fun findByTheme(
        @Query("theme") theme: String, @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<NewsResponse>

    @GET("top-headlines?sources=google-news-br")
    fun findTopHeadlines(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Call<NewsResponse>
}