package com.evaluation.techassigment.application

import android.app.Application
import com.evaluation.techassigment.di.module.appModule
import com.evaluation.techassigment.di.module.repoModule
import com.evaluation.techassigment.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Naveen on 27-07-2020.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //starting Koin dependency injection
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}