package com.example.multywork.utils.di

import com.example.multywork.presentation.fragments.ProfileFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(fragmentProfileFragment: ProfileFragment)
}