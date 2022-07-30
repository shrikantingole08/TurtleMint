package com.test.shared.model


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("current_page")
    var currentPage: Int? = null,
    @SerializedName("next_page")
    var nextPage: Int? = null,
    @SerializedName("prev_page")
    var prevPage: Any? = null,
    @SerializedName("total_count")
    var totalCount: Int? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    var webComics: List<String>? = null
)