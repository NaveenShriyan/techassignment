package com.evaluation.techassigment.networking

import com.evaluation.techassigment.datamodel.response.CountryDetailResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Naveen on 27-07-2020.
 */
interface APIService {
    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<CountryDetailResponse>
}