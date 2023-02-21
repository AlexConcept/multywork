package com.example.multywork.presentation.viewmodels

import androidx.lifecycle.*
import com.example.domain.entity.Skill
import com.example.domain.usecases.GetSkillById
import kotlinx.coroutines.launch


class SettingsSkillsViewModel(
    private val getSkillById: GetSkillById,
) : ViewModel() {

    private var _skills = MutableLiveData<Set<Skill>>()
    val skills: LiveData<Set<Skill>>
        get() = _skills

    init {
        getSkills()
    }

    private fun getSkills() {
        viewModelScope.launch {
            _skills.value = getSkillById.execute()
        }
    }
}

class SettingsSkillsViewModelFactory(
    val getSkillById: GetSkillById,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SettingsSkillsViewModel(
            getSkillById = getSkillById
        ) as T
    }
}