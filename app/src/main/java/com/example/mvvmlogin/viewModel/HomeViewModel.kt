package com.example.mvvmlogin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmlogin.data.network.Resource
import com.example.mvvmlogin.data.repository.UserRepository
import com.example.mvvmlogin.data.responses.LoginResponse

class HomeViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _user: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    private val user: LiveData<Resource<LoginResponse>> = MutableLiveData()
}
