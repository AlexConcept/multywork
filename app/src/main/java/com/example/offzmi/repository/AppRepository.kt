package com.example.offzmi.repository
import android.os.RemoteException
import com.example.offzmi.repository.backend.ApiService
import com.example.offzmi.repository.backend.models.UserDto

import retrofit2.HttpException

class AppRepository( val service: ApiService) {

   suspend fun getUserProfile(): UserDto {
       try {
           val userProfile = ApiService.ApiObject.retrofitService.getUserById("recocTGkklHkCXetE")
           return   userProfile
       } catch (ex: HttpException) {
           throw RemoteException(ex.message ?: "Request error!!!")
       }
   }
}