package com.example.multywork.utils

import com.example.data.AppRepositoryImpl
import com.example.data.backend.ApiService
import com.example.domain.repository.AppRepository
import com.example.domain.usecases.GetUserProfileUseCase

class AppContainer {

    private val service = ApiService.ApiObject.retrofitService
    val userRepositoryImpl = AppRepositoryImpl(service)

    private val appRepository =
    val getUserProfileUseCase = GetUserProfileUseCase(appRepository)

}


