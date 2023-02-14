package com.example.domain.repository

import com.example.domain.entity.Skill
import com.example.domain.entity.UserProfile


interface AppRepository {

    suspend fun getUserProfile(): UserProfile

    suspend fun getSkill(): Skill
}