package com.evaluation.techassigment.di.module

import com.evaluation.techassigment.repository.HomeRepository
import org.koin.dsl.module

/**
 * Created by Naveen on 28-07-2020.
 */
val repoModule = module {
    single {
        HomeRepository(get())
    }
}