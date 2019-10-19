package com.ephraimjp.smkkoding.connection

import com.ephraimjp.smkkoding.model.ResponseMovieModel
import com.ephraimjp.smkkoding.model.ResponseTvModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {

    @GET("movie/now_playing")
    fun getListMovieNowPlaying(
        @Query("api_key") apiKey : String,
        @Query("language") language : String
    ) : Observable<ResponseMovieModel>

    @GET("tv/top_rated")
    fun getListTvTopRated(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ) : Observable<ResponseTvModel>

}