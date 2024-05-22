package com.aldoj.yournewsapp.models

sealed class ResultState {

    data object NONE : ResultState()
    data object ERROR : ResultState()
    data object SUCCESS : ResultState()
    data object LOADING : ResultState()
}