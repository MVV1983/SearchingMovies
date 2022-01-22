package com.example.searchingmovies.presenter

import com.example.searchingmovies.interfaces.FilmInterface
import com.example.searchingmovies.model.repository.FilmRepository

class FilmPresenter(filmView: FilmInterface.FilmView):FilmInterface.FilmPresenter {
    private var view: FilmInterface.FilmView = filmView
    private var model: FilmInterface.FilmModel = FilmRepository()

    override fun networkcall(film: String) {
      model.getFilmNameByGenres(film,this)
    }

    override fun showFilm(): String {
        return model.getFilm()
    }

    override fun UIUpdate() {
        view.updateViewData()
    }

}