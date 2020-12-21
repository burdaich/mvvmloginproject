package com.example.mvvmlogin.data.repository

import com.example.mvvmlogin.data.UserPreferences
import com.example.mvvmlogin.data.network.AuthApi

class AuthRepository(
    private val api: AuthApi,
    private val userPreferences: UserPreferences
) : BaseRepository() {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall { api.login(email, password) }

    suspend fun saveAuthToken(token: String) {
        userPreferences.saveAuthToken(token)
    }
}