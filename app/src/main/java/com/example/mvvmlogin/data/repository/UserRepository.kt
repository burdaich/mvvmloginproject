package com.example.mvvmlogin.data.repository

import com.example.mvvmlogin.data.network.UserApi

 class UserRepository(
    private val api: UserApi
) : BaseRepository() {

    suspend fun getUser() = safeApiCall { api.getUser() }

}