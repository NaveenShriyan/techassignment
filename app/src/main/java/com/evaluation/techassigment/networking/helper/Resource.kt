package com.evaluation.techassigment.networking.helper

/**
 * Created by Naveen on 28-07-2020.
 *
 * Generic class for holding the status of network call and pass back to UI to display the message
 */
data class Resource<T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

    }

}