package com.example.searchingmovies.model.api


import com.example.searchingmovies.model.datamodel.Films
import com.example.searchingmovies.model.datamodel.Genres
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("films.json")
    fun getFilms(@Path("films") films: String): Call<List<Films>>

    @GET("genres")
    fun getGenres(@Path("genres") genres: String): Call<List<Genres>>
}