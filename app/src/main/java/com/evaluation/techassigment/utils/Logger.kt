package com.evaluation.techassigment.utils

import android.util.Log
import com.evaluation.techassigment.BuildConfig

/**
 * Created by Naveen on 27-07-2020.
 */
object Logger {
    @JvmStatic
    fun d(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg)

        }
    }

    @JvmStatic
    fun e(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg)

        }
    }
}