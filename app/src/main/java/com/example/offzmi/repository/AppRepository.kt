package com.example.offzmi.repository

import android.os.RemoteException
import com.example.offzmi.repository.backend.ApiService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class AppRepository(private val service: ApiService) {

    suspend fun getUserProfile(userId: Int) = flow <Int> {
        try {
            val userProfile = service.getUserById(userId)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Request error!!!")
        }
    }
}