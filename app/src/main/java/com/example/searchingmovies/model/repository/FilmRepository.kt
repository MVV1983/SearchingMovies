package com.example.searchingmovies.model.repository

import android.util.Log
import com.example.searchingmovies.interfaces.FilmInterface
import com.example.searchingmovies.model.api.API
import com.example.searchingmovies.model.api.RetrofitService
import com.example.searchingmovies.model.datamodel.Films
import com.example.searchingmovies.model.datamodel.Genres
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FilmRepository : FilmInterface.FilmModel {

    private var film = "fff"
    private var genreses = "aaa"
    private var apiclient: RetrofitService? = API.create()

    override fun getFilmNameByGenres(films: String, presenter: FilmInterface.FilmPresenter) {
        val call = apiclient?.getFilms(films)
        call?.enqueue(object : Callback<List<Films>> {
            override fun onResponse(call: Call<List<Films>>, response: Response<List<Films>>) {
                if (response.isSuccessful) {
                    val result = response.body()?.get(0)?.films
                    film = result.toString()
                    presenter.UIUpdate()
                }
            }

            override fun onFailure(call: Call<List<Films>>, t: Throwable) {
                Log.d("error", t.toString())
            }

        })
    }

    override fun getGenres(genres: String, presenter: FilmInterface.FilmPresenter) {
        val call = apiclient?.getGenres(genres)
        call?.enqueue(object : Callback<List<Genres>> {
            override fun onResponse(call: Call<List<Genres>>, response: Response<List<Genres>>) {
                if (response.isSuccessful) {
                    val result = response.body()?.get(7)?.genres
                    genreses = result.toString()
                    presenter.UIUpdate()
                }
            }

            override fun onFailure(call: Call<List<Genres>>, t: Throwable) {
                Log.d("error", t.toString())
            }

        })
    }

    override fun getFilm(): String {
        return film
    }
}