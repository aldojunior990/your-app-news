package com.aldoj.yournewsapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldoj.yournewsapp.repositories.NewsRepository
import kotlinx.coroutines.launch

class TopNewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            newsRepository.findTopHeadlines()
        }
    }
}