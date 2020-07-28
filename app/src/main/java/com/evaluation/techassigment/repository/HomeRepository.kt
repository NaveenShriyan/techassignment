package com.evaluation.techassigment.repository

import com.evaluation.techassigment.networking.APIService
import com.evaluation.techassigment.networking.UrlConstants

/**
 * Created by Naveen on 28-07-2020.
 */
class HomeRepository (private val apiService: APIService){
    suspend fun getCountryDetails() =  apiService.getCountryDetails(UrlConstants.apiKey)
}