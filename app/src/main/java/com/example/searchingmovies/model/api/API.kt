package com.example.searchingmovies.model.api

import com.example.searchingmovies.interfaces.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    // companion object{
    //  private var retrofit: Retrofit? = null
    //}

    fun create(): RetrofitService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RetrofitService::class.java)
    }
}