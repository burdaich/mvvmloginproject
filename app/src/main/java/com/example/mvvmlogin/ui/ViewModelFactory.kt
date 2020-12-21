package com.example.mvvmlogin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmlogin.repository.AuthRepository
import com.example.mvvmlogin.repository.BaseRepository
import com.example.mvvmlogin.viewModel.AuthViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: BaseRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("ViewModel not found")
        }
    }

}