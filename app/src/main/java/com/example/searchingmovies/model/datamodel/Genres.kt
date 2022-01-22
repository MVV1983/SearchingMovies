package com.example.searchingmovies.model.datamodel

import com.google.gson.annotations.SerializedName

data class Genres(
    @SerializedName("genres") val genres: List<Genres>
)


