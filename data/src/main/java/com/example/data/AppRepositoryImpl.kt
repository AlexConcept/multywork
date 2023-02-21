package com.example.data


import android.os.RemoteException
import com.example.data.backend.ApiService
import com.example.data.backend.models.UserResponse
import com.example.domain.entity.Skill
import com.example.domain.entity.UserProfile
import com.example.domain.repository.AppRepository
import retrofit2.HttpException

class AppRepositoryImpl(private val service: ApiService) : AppRepository {
    override suspend fun getUserProfile(): UserProfile {
        try {
            val user = ApiService.ApiObject.retrofitService.getUserById("recocTGkklHkCXetE")
            return userMapToDomain(user)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "User request error!!!")
        }
    }

    private fun userMapToDomain(user: UserResponse): UserProfile {
        return UserProfile(
            avatarBase64 = user.records[0].userFields.avatarBase64,
            company = user.records[0].userFields.company,
            firstName = user.records[0].userFields.firstName,
            lastName = user.records[0].userFields.lastName,
            position = user.records[0].userFields.position,
            rating = user.records[0].userFields.rating,
            role = user.records[0].userFields.role,
            verified = user.records[0].userFields.verified,
            id = user.records[0].userFields.id,
        )
    }

    override suspend fun getSkills(): List<Skill> {
        try {
            val skill = ApiService.ApiObject.retrofitService.getSkills()

            return skill.records.map { record ->
                Skill(
                    id = record.fields.id,
                    skillName = record.fields.skillName,
                    skillIconBase64 = record.fields.skillIconBase64
                )
            }
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Skill request error!!!")
        }
    }
}