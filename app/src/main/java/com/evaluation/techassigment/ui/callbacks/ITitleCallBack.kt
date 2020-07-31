package com.evaluation.techassigment.ui.callbacks

/**
 * Created by Naveen on 29-07-2020.
 *
 * interface responsible for handling callbacks and pass the title as args
 */
interface ITitleCallBack {
    fun onTittleReceived(title:String?,isFromDetail:Boolean)
}