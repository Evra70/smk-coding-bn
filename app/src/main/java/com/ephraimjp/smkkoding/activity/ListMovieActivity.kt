package com.ephraimjp.smkkoding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ephraimjp.smkkoding.R
import com.ephraimjp.smkkoding.adapter.TabLayoutAdapter
import kotlinx.android.synthetic.main.activity_list_movie.*

class ListMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movie)

        viewPager.adapter =
        TabLayoutAdapter(supportFragmentManager, this)

        tabLayout.setupWithViewPager(viewPager)
    }
}
