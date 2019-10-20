package com.ephraimjp.smkkoding.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResultsItem(

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("original_language")
    val originalLanguage: String? = null,

    @field:SerializedName("original_title")
    val originalTitle: String? = null,

    @field:SerializedName("video")
    val video: Boolean? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("genre_ids")
    val genreIds: List<Int?>? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    @field:SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @field:SerializedName("release_date")
    val releaseDate: String? = null,

    @field:SerializedName("popularity")
    val popularity: Double? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("adult")
    val adult: Boolean? = null,

    @field:SerializedName("vote_count")
    val voteCount: Int? = null
) : Parcelable {

//    constructor(id:Int?,title: String?,popularity: Double?,posterPath: String?,overview: String?)
//            : this(id = id, title = title, popularity = popularity, posterPath = posterPath, overview = overview)

    companion object {
        const val T_FAVORITE    = "t_favorite"
        const val C_FAVORITE_ID   = "favorite_id"
        const val C_POSTER_PATH   = "poster_path"
        const val C_RATING        = "rating"
        const val C_TITLE         = "title"
        const val C_DESCRIPTION   = "description"
    }
}