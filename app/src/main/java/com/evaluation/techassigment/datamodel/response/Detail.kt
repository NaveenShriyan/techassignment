package com.evaluation.techassigment.datamodel.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Response data model , made this class as Parcelize to transfer model through argument
 */
@Parcelize
data class Detail(
    val description: String?,
    @SerializedName("imageHref")
    val imageURL: String?,
    val title: String?
) : Parcelable