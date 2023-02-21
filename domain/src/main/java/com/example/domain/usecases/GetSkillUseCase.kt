package com.example.domain.usecases

import com.example.domain.entity.Skill
import com.example.domain.repository.AppRepository

class GetSkillById(private val appRepository: AppRepository) {

    suspend fun execute(): Set<Skill> {
        return appRepository.getSkills().toSet()
    }
}