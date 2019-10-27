package com.ephraimjp.smkkoding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.ephraimjp.smkkoding.R
import com.ephraimjp.smkkoding.database.database
import com.ephraimjp.smkkoding.model.DatabaseConstract
import kotlinx.android.synthetic.main.activity_detail_favorite.*
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_detail_movie.fav_movie_button
import kotlinx.android.synthetic.main.activity_detail_movie.movie_description
import kotlinx.android.synthetic.main.activity_detail_movie.movie_poster
import kotlinx.android.synthetic.main.activity_detail_movie.movie_rating
import kotlinx.android.synthetic.main.activity_detail_movie.movie_title
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class DetailFavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_favorite)

        val movie = intent.getParcelableExtra<DatabaseConstract?>("favorite")

        favorite_title.text = movie?.title
        favorite_rating.text = "Rating : ${movie?.rating}"
        favorite_description.text = movie?.description
        Glide.with(this).load("https://image.tmdb.org/t/p/w500" + movie?.posterPath)
            .into(favorite_poster)


        fav_favorite_button.onClick {
            deleteMovieFavorite(movie)
        }
    }

    private fun deleteMovieFavorite(movie: DatabaseConstract?) {
        database.use {
            delete(
                DatabaseConstract.T_FAVORITE,
                "${DatabaseConstract.C_TITLE} = {title}",
                "title" to movie?.title.toString()
            )
            toast("Movie dihapus dari daftar favorite")
        }
        startActivity(intentFor<ListFavorite>())
    }

}
