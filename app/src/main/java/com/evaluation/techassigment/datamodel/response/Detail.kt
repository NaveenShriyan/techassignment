package com.evaluation.techassigment.datamodel.response


import com.google.gson.annotations.SerializedName

data class Detail(
    val description: String?,
    @SerializedName("imageHref")
    val imageURL: String?,
    val title: String?
)