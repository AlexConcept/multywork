package com.example.offzmi.repository

import android.os.RemoteException
import com.example.offzmi.repository.backend.ApiService
import com.example.offzmi.repository.backend.models.UserDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class AppRepository(private val service: ApiService) {

   suspend fun getUserProfile(userId: Int): Flow<UserDto> {
       try {
           val userProfile = service.getUserById(userId)
           return flow { userProfile }
       } catch (ex: HttpException) {
           throw RemoteException(ex.message ?: "Request error!!!")
       }
   }
}