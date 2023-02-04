package com.example.data


import android.os.RemoteException
import com.example.data.backend.ApiService
import com.example.data.backend.models.UserResponse
import com.example.domain.entity.UserProfile
import com.example.domain.repository.AppRepository
import retrofit2.HttpException

class AppRepositoryImpl(private val service: ApiService) : AppRepository {
    override suspend fun getUserProfile(): UserProfile {
        try {
            val user = ApiService.ApiObject.retrofitService.getUserById("recocTGkklHkCXetE")
            return mapToDomain(user)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Request error!!!")
        }
    }

    private fun mapToDomain(user: UserResponse): UserProfile {
        return UserProfile(
            avatarBase64 = user.records[0].fields.avatarBase64,
            company = user.records[0].fields.company,
            firstName = user.records[0].fields.firstName,
            lastName = user.records[0].fields.lastName,
            position = user.records[0].fields.position,
            rating = user.records[0].fields.rating,
            role = user.records[0].fields.role,
            verified = user.records[0].fields.verified,
            id = user.records[0].fields.id,
        )
    }
}