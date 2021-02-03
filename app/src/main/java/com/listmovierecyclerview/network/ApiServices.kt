package com.listmovierecyclerview.network

import retrofit2.Call
import com.listmovierecyclerview.model.ResponseMovies
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    // Real Url :
   //https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=dd88340ca1645f1a6ce0a917acae8653
    @GET("movie")
    fun requestGetMovies(
            @Query("sort_by") sort_by: String? = "popularity.desc",
            @Query("api_key") api_key: String? = null
    ): Call<ResponseMovies>
}