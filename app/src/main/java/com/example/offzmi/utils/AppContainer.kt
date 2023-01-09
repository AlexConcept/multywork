package com.example.offzmi.utils

import com.example.offzmi.repository.AppRepository
import com.example.offzmi.repository.backend.ApiService

class AppContainer {

    private val service = ApiService.ApiObject.retrofitService
    val userRepository = AppRepository(service)
}