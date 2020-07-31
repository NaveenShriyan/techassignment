package com.evaluation.techassigment.di.module

import android.content.Context
import com.evaluation.techassigment.BuildConfig
import com.evaluation.techassigment.networking.APIService
import com.evaluation.techassigment.networking.UrlConstants
import com.evaluation.techassigment.networking.helper.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Naveen on 28-07-2020.
 *
 * Application level module for Dependency Injection
 */

val appModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
    single { provideNetworkHelper(androidContext()) }
}

private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

/**
 * If needed you can add Api header, API key or Query Parameter through interceptor
 */
private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(10,TimeUnit.SECONDS)
        .build()
} else OkHttpClient
    .Builder()
    .connectTimeout(10,TimeUnit.SECONDS)
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(UrlConstants.BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): APIService =
    retrofit.create(APIService::class.java)
