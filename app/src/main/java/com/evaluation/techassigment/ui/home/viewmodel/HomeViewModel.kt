package com.evaluation.techassigment.ui.home.viewmodel

import com.evaluation.techassigment.networking.helper.NetworkHelper
import com.evaluation.techassigment.repository.HomeRepository
import com.evaluation.techassigment.ui.base.BaseViewModel

/**
 * Created by Naveen on 28-07-2020.
 */
class HomeViewModel(private val homeRepository: HomeRepository,
                       private val networkHelper: NetworkHelper
) : BaseViewModel() {

}