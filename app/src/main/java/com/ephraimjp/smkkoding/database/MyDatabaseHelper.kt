package com.ephraimjp.smkkoding.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.ephraimjp.smkkoding.model.MovieResultsItem
import org.jetbrains.anko.db.*

class MyDatabaseHelper (context: Context)
    : ManagedSQLiteOpenHelper(context,
    "database_film.db",
    null,
    1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
            MovieResultsItem.T_FAVORITE,
            true,
            MovieResultsItem.C_FAVORITE_ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            MovieResultsItem.C_TITLE to TEXT,
            MovieResultsItem.C_RATING to REAL,
            MovieResultsItem.C_POSTER_PATH to TEXT,
            MovieResultsItem.C_DESCRIPTION to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(MovieResultsItem.T_FAVORITE)
        onCreate(db)

    }
}

val Context.database : MyDatabaseHelper
    get() = MyDatabaseHelper(applicationContext)