package com.ephraimjp.smkkoding.model

import com.google.gson.annotations.SerializedName

data class ResponseMovieModel(

	@field:SerializedName("results")
	val movieResults: List<MovieResultsItem?>? = null,

	@field:SerializedName("dates")
	val dates: Dates? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)