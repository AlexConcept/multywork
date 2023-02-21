package com.example.multywork.utils.di

import android.content.Context
import com.example.domain.usecases.GetSkillById
import com.example.domain.usecases.GetUserProfileUseCase
import com.example.multywork.presentation.viewmodels.ProfileViewModelFactory
import com.example.multywork.presentation.viewmodels.SettingsSkillsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val  context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideProfileViewModuleFactory(getUserProfileUseCase: GetUserProfileUseCase): ProfileViewModelFactory {
        return ProfileViewModelFactory(getUserProfileUseCase = getUserProfileUseCase)
    }

    @Provides
    fun provideSettingsSkillsViewModelFactory(getSkillById: GetSkillById): SettingsSkillsViewModelFactory {
        return SettingsSkillsViewModelFactory(getSkillById = getSkillById)
    }
}