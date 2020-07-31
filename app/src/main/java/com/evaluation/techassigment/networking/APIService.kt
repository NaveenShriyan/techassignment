@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection")

package com.evaluation.techassigment.networking

import com.evaluation.techassigment.datamodel.response.CountryDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Naveen on 27-07-2020.
 */
interface APIService {
    @GET("{apiKey}/facts.json")
    suspend  fun getCountryDetails(@Path("apiKey") key: String): Response<CountryDetailResponse>
}