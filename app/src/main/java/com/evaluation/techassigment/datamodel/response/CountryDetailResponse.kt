package com.evaluation.techassigment.datamodel.response

import com.google.gson.annotations.SerializedName


data class CountryDetailResponse(
    @SerializedName("rows")
    val detailList: List<Detail>,
    val title: String
)