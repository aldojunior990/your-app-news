package com.aldoj.yournewsapp.di

import com.aldoj.yournewsapp.network.NewsService
import com.aldoj.yournewsapp.repositories.NewsRepository
import com.aldoj.yournewsapp.ui.viewmodels.TopNewsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()

        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsapi.org/v2/").client(client)
            .build()

        retrofit.create(NewsService::class.java)
    }
}

val repositoriesModule = module {
    singleOf(::NewsRepository)
}

val viewModelsModule = module {
    viewModelOf(::TopNewsViewModel)
}

