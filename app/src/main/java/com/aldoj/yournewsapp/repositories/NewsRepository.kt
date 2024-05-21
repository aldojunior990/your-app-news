package com.aldoj.yournewsapp.repositories

import android.util.Log
import com.aldoj.yournewsapp.models.NewsResponse
import com.aldoj.yournewsapp.network.NewsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(private val newsService: NewsService) {
    suspend fun findTopHeadlines() {
        try {
            newsService.findTopHeadlines().enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>, response: Response<NewsResponse>
                ) {
                    Log.d("TESTE", response.body().toString())
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        } catch (e: Exception) {
            Log.d("TESTE", e.toString())
        }
    }
}