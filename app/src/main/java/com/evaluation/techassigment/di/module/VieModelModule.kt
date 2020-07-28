package com.evaluation.techassigment.di.module

import com.evaluation.techassigment.ui.home.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Naveen on 28-07-2020.
 */

val viewModelModule = module {
    viewModel {
        HomeViewModel(get(),get())
    }
}