package com.evaluation.techassigment.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evaluation.techassigment.application.Constants
import com.evaluation.techassigment.datamodel.response.CountryDetailResponse
import com.evaluation.techassigment.datamodel.response.Detail
import com.evaluation.techassigment.networking.helper.NetworkHelper
import com.evaluation.techassigment.networking.helper.Resource
import com.evaluation.techassigment.repository.HomeRepository
import com.evaluation.techassigment.ui.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by Naveen on 28-07-2020.
 */
class HomeViewModel(
    private val homeRepository: HomeRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {

    private val _countryDetail = MutableLiveData<Resource<CountryDetailResponse>>()
    val countryDetail: LiveData<Resource<CountryDetailResponse>>
        get() = _countryDetail

    init {
        fetchDetails()
    }

    private fun fetchDetails() {
        viewModelScope.launch {
            _countryDetail.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                homeRepository.getCountryDetails().let {
                    if (it.isSuccessful) {
                        _countryDetail.postValue(Resource.success(it.body()))
                    } else _countryDetail.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _countryDetail.postValue(Resource.error(Constants.NO_INTERNET_CONNECTION, null))
        }
    }

}