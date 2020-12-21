package com.example.mvvmlogin.repository

import com.example.mvvmlogin.network.AuthApi

class AuthRepository(
    private val api: AuthApi
) : BaseRepository() {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall { api.login(email, password) }
}