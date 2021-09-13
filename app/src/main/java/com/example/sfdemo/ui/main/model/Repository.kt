package com.example.sfdemo.ui.main.model

interface Repository {

    fun getFilmFromServer(): FilmEntity
    fun getFilmFromLocalStorage(): List<FilmEntity>
}