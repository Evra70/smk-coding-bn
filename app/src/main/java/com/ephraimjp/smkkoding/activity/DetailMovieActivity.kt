package com.ephraimjp.smkkoding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.ephraimjp.smkkoding.R
import com.ephraimjp.smkkoding.database.database
import com.ephraimjp.smkkoding.model.DatabaseConstract
import com.ephraimjp.smkkoding.model.MovieResultsItem
import kotlinx.android.synthetic.main.activity_detail_movie.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class DetailMovieActivity : AppCompatActivity() {

    var isMovieFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra<MovieResultsItem?>("movie")

        movie_title.text = movie?.title
        movie_rating.text = "Rating : ${movie?.popularity}"
        movie_description.text = movie?.overview
        Glide.with(this).load("https://image.tmdb.org/t/p/w500" + movie?.posterPath)
            .into(movie_poster)

        checkMovieFavorite(movie)

        fav_movie_button.onClick {
            if (isMovieFavorite) {
                deleteMovieFavorite(movie)
            } else {
                addMovieToFavorite(movie)
            }
        }
    }

    private fun deleteMovieFavorite(movie: MovieResultsItem?) {
        database.use {
            delete(
                MovieResultsItem.T_FAVORITE,
                "${MovieResultsItem.C_TITLE} = {title}",
                "title" to movie?.title.toString()
            )
            toast("Movie dihapus dari daftar favorite")
            isMovieFavorite = false
            fav_movie_button.text = "Tambah Favorite"
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
        isMovieFavorite = true
        fav_movie_button.text = "Hapus Favorite"
    }

    private fun checkMovieFavorite(movie: MovieResultsItem?) {
        //TODO Pengecekan film
        database.use {
            val isFavorite = select(MovieResultsItem.T_FAVORITE)
                .whereArgs(
                    MovieResultsItem.C_TITLE + " = {title}",
                    "title" to movie?.title.toString()
                )
            val dataMovie = isFavorite.parseOpt(classParser<DatabaseConstract>())

            Log.d("FAVORITE MOVIE", dataMovie.toString())

            if (dataMovie != null) {
                isMovieFavorite = true
                fav_movie_button.text = "Hapus Favorite"
            } else {
                isMovieFavorite = false
                fav_movie_button.text = "Tambah Favorite"
            }
        }

    }

}
