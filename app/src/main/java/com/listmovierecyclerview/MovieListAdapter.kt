package com.listmovierecyclerview

import android.content.Context
import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.listmovierecyclerview.model.ResultsItem
import kotlinx.android.synthetic.main.activity_detail.view.tvMovieTitle
import kotlinx.android.synthetic.main.list_movie_item.view.*


class MovieListAdapter (val context: Context,val dataMovies: List<ResultsItem?>?)  : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, Position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_movie_item,parent, false))
    }

    override fun getItemCount(): Int = dataMovies?.count()!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataMovies?.get(position))
        //TODO: Click event
        holder.itemView.setOnClickListener{

            //make intent
            val intent = Intent(context, DetailActivity::class.java)
            //Put Data
            intent.putExtra("MV_TITLE", dataMovies?.get(position)?.title)
            intent.putExtra("MV_DESC", dataMovies?.get(position)?.overview)
            intent.putExtra("MV_RATING", dataMovies?.get(position)?.voteAverage.toString())
            intent.putExtra("MV_POPULAR", dataMovies?.get(position)?.popularity.toString())
            intent.putExtra("MV_POSTER", dataMovies?.get(position)?.posterPath)
            //start new activity
            context.startActivity(intent)
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(movie: ResultsItem?) {
            itemView.tvMovieTitle.text = movie?.title
           val imageUrl = "https://image.tmdb.org/t/p/w500${movie?.posterPath}"
//            Picasso.with()
//          Picasso.get()
//                  .load(imageUrl)
//                  .into(itemView.ivMovieThumbnail)

           // Glide.with(itemView.context).load(imageUrl).into(itemView.ivMovieThumbnail)
          Glide.with(itemView.context).load(imageUrl).into(itemView.ivMovieThumbnail)

        }
    }
}