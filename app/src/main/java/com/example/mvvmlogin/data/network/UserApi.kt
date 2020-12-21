package com.example.mvvmlogin.data.network

import com.example.mvvmlogin.data.responses.LoginResponse
import retrofit2.http.GET

interface UserApi {
    @GET("user")
    suspend fun getUser(): LoginResponse
}