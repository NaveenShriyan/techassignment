package com.evaluation.techassigment.di.module

import com.evaluation.techassigment.repository.HomeRepository
import org.koin.dsl.module

/**
 * Created by Naveen on 28-07-2020.
 *
 * Module which holds all the repositories which is used for dependency
 */
val repoModule = module {
    single {
        HomeRepository(get())
    }
}