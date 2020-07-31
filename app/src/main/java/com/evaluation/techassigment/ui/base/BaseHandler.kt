package com.evaluation.techassigment.ui.base

import android.view.View

/**
 * Created by Naveen on 27-07-2020.
 *
 * Interface which is responsible for handling clicks for the views in XML.
 */
interface BaseHandler<T> {
    fun onClick(view: View, data: T)
}