package com.evaluation.techassigment.repository

import com.evaluation.techassigment.networking.APIService
import com.evaluation.techassigment.networking.UrlConstants

/**
 * Created by Naveen on 28-07-2020.
 *
 * Class which is responsible for interaction with the webservices and databases calls,
 * Consolidate place to call both network or database related query
 */
class HomeRepository (private val apiService: APIService){
    suspend fun getCountryDetails() =  apiService.getCountryDetails(UrlConstants.apiKey)
}