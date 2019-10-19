package com.ephraimjp.smkkoding.model

import com.google.gson.annotations.SerializedName

data class ResponseTvModel(

	@field:SerializedName("results")
	val tvResults: List<TvResultsItem?>? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)