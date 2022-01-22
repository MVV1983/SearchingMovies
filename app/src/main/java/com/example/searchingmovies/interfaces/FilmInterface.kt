package com.example.searchingmovies.interfaces

import Film
import com.example.searchingmovies.model.datamodel.Films


interface FilmInterface {
    interface FilmModel{
        //fun getAllFilms(films: String,presenter: FilmPresenter)
        fun getFilmNameByGenres(films: String,presenter: FilmPresenter)
        fun getGenres(genres: String,presenter: FilmPresenter)
        fun getFilm():String
    }
    interface FilmView{
        fun updateViewData()
    }
    interface  FilmPresenter{
        fun networkcall(film: String)
        fun showFilm():String
        fun UIUpdate()
    }
}