package com.example.sfdemo.ui.main.model

class RepositoryImpl : Repository {
    override fun getFilmFromServer(): FilmEntity {
        TODO("Not yet implemented")
    }

    override fun getFilmFromLocalStorage(): List<FilmEntity> = listOf(FilmEntity(),
        FilmEntity(),FilmEntity
    ())
}