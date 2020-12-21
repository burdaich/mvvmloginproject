package com.example.mvvmlogin.viewModel

import androidx.lifecycle.ViewModel
import com.example.mvvmlogin.repository.AuthRepository

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel()