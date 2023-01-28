package com.example.multywork.utils

import com.example.multywork.repository.AppRepository
import com.example.multywork.repository.backend.ApiService

class AppContainer {

    private val service = ApiService.ApiObject.retrofitService
    val userRepository = AppRepository(service)
}