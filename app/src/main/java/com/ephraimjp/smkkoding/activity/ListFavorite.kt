package com.ephraimjp.smkkoding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ephraimjp.smkkoding.R
import com.ephraimjp.smkkoding.adapter.FavoriteAdapter
import com.ephraimjp.smkkoding.adapter.MovieAdapter
import com.ephraimjp.smkkoding.database.MyApplication
import com.ephraimjp.smkkoding.database.database
import com.ephraimjp.smkkoding.model.DatabaseConstract
import com.ephraimjp.smkkoding.model.MovieResultsItem
import kotlinx.android.synthetic.main.activity_list_favorite.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class ListFavorite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_favorite)
        selectFavoriteListFromSqlLite()
    }

    private fun selectFavoriteListFromSqlLite() {
        database.use {
            val selectData = select(DatabaseConstract.T_FAVORITE)
            val list: List<DatabaseConstract> =
                selectData.parseList(classParser<DatabaseConstract>())
            val layoutmanager = LinearLayoutManager(applicationContext)
            val adapter = FavoriteAdapter(list, applicationContext)

            rv_favorite.apply {
                layoutManager = layoutmanager
                setAdapter(adapter)
            }
        }
    }
}
