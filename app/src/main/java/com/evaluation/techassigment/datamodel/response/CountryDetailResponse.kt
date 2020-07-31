package com.evaluation.techassigment.datamodel.response

import com.google.gson.annotations.SerializedName

/**
 * Response data model
 */
data class CountryDetailResponse(
    @SerializedName("rows")
    val detailList: List<Detail>,
    val title: String
)