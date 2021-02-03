package com.listmovierecyclerview.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InitRetrofit {

    companion object {
        val API_KEY = "dd88340ca1645f1a6ce0a917acae8653"
        // Real Url :
        // https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=dd88340ca1645f1a6ce0a917acae8653
        val BASE_URL = "https://api.themoviedb.org/3/discover/";

        fun getInit(): Retrofit {
            return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        }
        fun getInstance(): ApiServices{
            return getInit().create(ApiServices::class.java)
        }
        //mengalami error pada ResponseMOvies
    }

}