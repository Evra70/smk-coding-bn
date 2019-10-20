package com.ephraimjp.smkkoding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ephraimjp.smkkoding.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_profile.onClick {
            startActivity(intentFor<ProfileActivity>())
        }

        button_favorite_movie.onClick {
            startActivity(intentFor<ListFavorite>())
        }

        button_movie_list.onClick {
            //          cara normal :  val intent = Intent(this@MainActivity,ListMovieActivity::class.java)
//            startActivity(intent)
            startActivity(intentFor<ListMovieActivity>())
        }
    }


}
