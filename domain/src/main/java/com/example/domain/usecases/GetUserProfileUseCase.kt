package com.example.domain.usecases

import com.example.domain.entity.UserProfile
import com.example.domain.repository.AppRepository

class GetUserProfileUseCase(private val appRepository: AppRepository) {

    suspend fun execute(): UserProfile {
        return  appRepository.getUserProfile()
    }
}