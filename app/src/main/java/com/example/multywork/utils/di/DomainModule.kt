package com.example.multywork.utils.di

import com.example.domain.repository.AppRepository
import com.example.domain.usecases.GetSkillById
import com.example.domain.usecases.GetUserProfileUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserProfileUseCase(appRepository: AppRepository): GetUserProfileUseCase {
        return GetUserProfileUseCase(appRepository = appRepository)
    }

    @Provides
    fun provideGetSkillUseCase(appRepository: AppRepository): GetSkillById {
        return GetSkillById(appRepository = appRepository)
    }
}