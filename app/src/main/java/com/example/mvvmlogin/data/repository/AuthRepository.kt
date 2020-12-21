package com.example.mvvmlogin.data.repository

import com.example.mvvmlogin.data.network.AuthApi

class AuthRepository(
    private val api: AuthApi
) : BaseRepository() {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall { api.login(email, password) }
}