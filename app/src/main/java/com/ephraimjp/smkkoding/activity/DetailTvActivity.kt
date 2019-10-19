package com.ephraimjp.smkkoding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.ephraimjp.smkkoding.R
import com.ephraimjp.smkkoding.model.TvResultsItem
import kotlinx.android.synthetic.main.activity_detail_tv.*

class DetailTvActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)

        val tv = intent.getParcelableExtra<TvResultsItem?>("tv")

        tv_title.text = tv?.originalName
        tv_rating.text = "Rating : ${tv?.popularity}"
        tv_description.text = tv?.overview
        Glide.with(this).load("https://image.tmdb.org/t/p/w500" + tv?.posterPath).into(tv_poster)

    }
}
