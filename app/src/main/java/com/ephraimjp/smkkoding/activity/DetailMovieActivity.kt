package com.ephraimjp.smkkoding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.ephraimjp.smkkoding.R
import com.ephraimjp.smkkoding.model.MovieModel
import com.ephraimjp.smkkoding.model.MovieResultsItem
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.item_movie.*

class DetailMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra<MovieResultsItem?>("movie")

        movie_title.text = movie?.title
        movie_rating.text = "Rating : ${movie?.popularity}"
        movie_description.text = movie?.overview
        Glide.with(this).load("https://image.tmdb.org/t/p/w500" + movie?.posterPath).into(movie_poster)
    }
}
