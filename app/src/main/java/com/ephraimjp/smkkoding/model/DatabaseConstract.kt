package com.ephraimjp.smkkoding.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DatabaseConstract(
    val id: Long? = null,
    val title: String? = null,
    val rating: Double? = null,
    val posterPath: String? = null,
    val description: String? = null
) : Parcelable {
    companion object {
        const val T_FAVORITE = "t_favorite"
        const val C_FAVORITE_ID = "favorite_id"
        const val C_POSTER_PATH = "poster_path"
        const val C_RATING = "rating"
        const val C_TITLE = "title"
        const val C_DESCRIPTION = "description"
    }
}
