package com.aldoj.yournewsapp

import android.app.Application
import com.aldoj.yournewsapp.di.networkModule
import com.aldoj.yournewsapp.di.repositoriesModule
import com.aldoj.yournewsapp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MainApplication)
            modules(networkModule, repositoriesModule, viewModelsModule)
        }
    }
}