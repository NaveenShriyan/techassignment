package com.evaluation.techassigment.ui.base

import android.view.View

/**
 * Created by Naveen on 27-07-2020.
 */
interface BaseHandler<T> {
    fun onClick(view: View, data: T)
}