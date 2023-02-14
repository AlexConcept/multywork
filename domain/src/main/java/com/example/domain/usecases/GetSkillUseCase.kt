package com.example.domain.usecases

import com.example.domain.entity.Skill
import com.example.domain.repository.AppRepository

class GetSkillUseCase(private val appRepository: AppRepository) {

    suspend fun execute(): Skill {
        return appRepository.getSkill()
    }
}