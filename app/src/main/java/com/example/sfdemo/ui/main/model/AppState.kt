package com.example.sfdemo.ui.main.model

sealed class AppState {
    data class Success(val FilmData: List<FilmEntity>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}