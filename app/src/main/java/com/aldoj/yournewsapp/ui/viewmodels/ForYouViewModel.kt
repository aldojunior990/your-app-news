package com.aldoj.yournewsapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldoj.yournewsapp.models.NewsResult
import com.aldoj.yournewsapp.models.Theme
import com.aldoj.yournewsapp.repositories.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ForYouViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _articles = MutableStateFlow(NewsResult())
    val articles get() = _articles.asStateFlow()

    private val _themes: MutableStateFlow<MutableList<Theme>> = MutableStateFlow(
        mutableListOf(
            Theme(title = "Esportes", isActive = false),
            Theme(title = "Politica", isActive = false),
            Theme(title = "Saúde", isActive = false),
            Theme(title = "Comédia", isActive = false),
        )
    )

    val themes: StateFlow<MutableList<Theme>> get() = _themes.asStateFlow()
    fun onClickThemeChip(index: Int) {
        val newState = !(_themes.value[index].isActive)
        val updatedList = _themes.value
        updatedList[index].isActive = newState
        _themes.value = updatedList
        Log.d("TESTE", _themes.value.toString())
    }

    fun addNewTheme(title: String) {
        _themes.value.add(Theme(title, true))
    }


}