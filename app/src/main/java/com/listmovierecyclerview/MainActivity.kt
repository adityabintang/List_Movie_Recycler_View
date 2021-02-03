package com.listmovierecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.listmovierecyclerview.model.ResponseMovies
import com.listmovierecyclerview.network.InitRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: Siapkan Data-data
        val movieNames = resources.getStringArray(R.array.list_movie_names)
        val movieDesc = resources.getStringArray(R.array.list_movie_sinopsis)
        val movieImages = R.array.list_movie_images

        //TODO: Siapkan layout manager
       rvMovieList.layoutManager = LinearLayoutManager(this)

        //TODO: GET data dari API
        val apiServices = InitRetrofit.getInstance()
        apiServices.requestGetMovies("popularity.desc", InitRetrofit.API_KEY).enqueue(object : Callback<ResponseMovies> {
            override fun onFailure(call: Call<ResponseMovies>, t: Throwable)
            {
                t.printStackTrace()
            }
            override fun onResponse(call: Call<ResponseMovies>, response: Response<ResponseMovies>) {
                if(response.isSuccessful) {
                    val dataMovies = response.body()?.results
                    //TODO: Set Adapter ke Recycler View

                   // Log.d("TAG", response.body()?.results.toString())

                    rvMovieList.adapter = dataMovies?.let {
                        MovieListAdapter(this@MainActivity,
                            it
                        )
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Response gagal", Toast.LENGTH_SHORT).show()
                }
            }
        })
        //TODO: set adapter ke Recycler View
      // rvMovieList.adapter = MovieListAdapter(this, movieNames, movieDesc, movieImages)

    }
}