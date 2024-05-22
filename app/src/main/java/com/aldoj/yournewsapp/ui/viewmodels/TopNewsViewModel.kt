package com.aldoj.yournewsapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldoj.yournewsapp.models.NewsResult
import com.aldoj.yournewsapp.repositories.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class TopNewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _articles = MutableStateFlow(NewsResult())
    val articles get() = _articles.asStateFlow()

    init {
        viewModelScope.launch {
            newsRepository.findTopHeadlines().collect {
                _articles.value = it
            }
        }
    }

    fun refreshArticles() {
        viewModelScope.launch {
            _articles.value = NewsResult()
            newsRepository.findTopHeadlines().collect {
                _articles.value = it
            }
        }
    }
}