package com.example.mvvmlogin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.mvvmlogin.data.network.Resource
import com.example.mvvmlogin.data.network.UserApi
import com.example.mvvmlogin.data.repository.UserRepository
import com.example.mvvmlogin.data.responses.LoginResponse
import com.example.mvvmlogin.data.responses.User
import com.example.mvvmlogin.databinding.FragmentHomeBinding
import com.example.mvvmlogin.viewModel.HomeViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, UserRepository>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressbar.visible(false)

        viewModel.getUser()

        viewModel.user.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    updateUI(it.value.user)
                    binding.progressbar.visible(false)
                }

                is Resource.Loading -> {
                    binding.progressbar.visible(true)
                }
            }
        })
    }

    private fun updateUI(user: User) {
        with(binding) {
            textViewId.text = user.id.toString()
            textViewName.text = user.name.toString()
            textViewEmail.text = user.email.toString()
        }

    }

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): UserRepository {
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(UserApi::class.java, token)
        return UserRepository(api)
    }


}