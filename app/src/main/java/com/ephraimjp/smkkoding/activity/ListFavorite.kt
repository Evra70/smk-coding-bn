package com.ephraimjp.smkkoding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ephraimjp.smkkoding.R
import com.ephraimjp.smkkoding.database.database
import com.ephraimjp.smkkoding.model.DatabaseConstract
import com.ephraimjp.smkkoding.model.MovieResultsItem
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
            val selectData = select(MovieResultsItem.T_FAVORITE)
            val list: List<DatabaseConstract> =
                selectData.parseList(classParser<DatabaseConstract>())
        }
    }
}
