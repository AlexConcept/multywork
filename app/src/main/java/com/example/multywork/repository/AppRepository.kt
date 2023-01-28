package com.example.multywork.repository
import android.os.RemoteException
import com.example.multywork.repository.backend.ApiService
import com.example.multywork.repository.backend.models.UserResponse

import retrofit2.HttpException

class AppRepository(val service: ApiService) {
   suspend fun getUserProfile(): UserResponse {
       try {
           val userProfile = ApiService.ApiObject.retrofitService.getUserById("recocTGkklHkCXetE")
           return   userProfile
       } catch (ex: HttpException) {
           throw RemoteException(ex.message ?: "Request error!!!")
       }
   }
}