package com.example.mvvmlogin.network

import okhttp3.ResponseBody

sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failed(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorReady: ResponseBody?
    )
}