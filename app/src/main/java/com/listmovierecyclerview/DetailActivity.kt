package com.listmovierecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //TODO: Get data from intent
        val movieTitle = intent.getStringExtra("MV_TITILE")
        val movieDesc = intent.getStringExtra("MV_DESC")
        val movieRating = intent.getStringExtra("MV_RATING")
        val moviePopularity = intent.getStringExtra("MV_POPULAR")
        val movieImageUrl = "https://image.tmdb.org/t/p/w500${intent.getStringExtra("MV_POSTER")}"

        //TODO set Data to widget
        supportActionBar?.title = movieTitle

        tvMovieTitle.text = movieTitle
        tvMovieDesc.text = movieDesc
        tvMoviePopularity.text = "Popularity : $moviePopularity"
        tvMovieRating.text = "Rating : $movieRating"


//    Picasso.get()
//        .load(movieImageUrl)
//        .into(ivMoviePoster)
        Glide.with(this).load(movieImageUrl)
            .apply {
                RequestOptions()
                    .error(R.drawable.ic_launcher_background)
            }
            .into(ivMoviePoster)

//        val typedImages = resources.obtainTypedArray(R.array.list_movie_images)
//        val movieImage = typedImages.getResourceId(movieImagePosition, 0)

//        ivMoviePoster.setImageResource(movieImage)
    }

}