package com.ephraimjp.smkkoding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.ephraimjp.smkkoding.R
import com.ephraimjp.smkkoding.database.database
import com.ephraimjp.smkkoding.model.MovieResultsItem
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class DetailMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra<MovieResultsItem?>("movie")

        movie_title.text = movie?.title
        movie_rating.text = "Rating : ${movie?.popularity}"
        movie_description.text = movie?.overview
        Glide.with(this).load("https://image.tmdb.org/t/p/w500" + movie?.posterPath)
            .into(movie_poster)

        button_favorite_movie.onClick {
            //checkMovieFavorite(movie)
            addMovieToFavorite(movie)
        }
    }

    private fun addMovieToFavorite(movie: MovieResultsItem?) {
        database.use {
            insert(
                MovieResultsItem?.T_FAVORITE,
                MovieResultsItem?.C_TITLE to movie?.title,
                MovieResultsItem?.C_POSTER_PATH to movie?.posterPath,
                MovieResultsItem?.C_RATING to movie?.popularity,
                MovieResultsItem?.C_DESCRIPTION to movie?.overview
            )
        }
        toast("Berhasil di tambahkan ke Favorite!!!")
    }

    private fun checkMovieFavorite(movie: MovieResultsItem?) {
        //TODO Pengecekan film
    }

}
