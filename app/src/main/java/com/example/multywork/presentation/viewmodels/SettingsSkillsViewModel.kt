package com.example.multywork.presentation.viewmodels

import androidx.lifecycle.*
import com.example.domain.entity.Skill
import com.example.domain.usecases.GetSkillUseCase
import kotlinx.coroutines.launch


class SettingsSkillsViewModel(
    private val getSkillUseCase: GetSkillUseCase,
) : ViewModel() {

    private var _skill = MutableLiveData<Skill>()
    val skill: LiveData<Skill>
        get() = _skill

    init {
        getSkill()
    }

    private fun getSkill() {
        viewModelScope.launch {
            _skill.value = getSkillUseCase.execute()
        }
    }
}

class SettingsSkillsViewModelFactory(
    val getSkillUseCase: GetSkillUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SettingsSkillsViewModel(
            getSkillUseCase = getSkillUseCase
        ) as T
    }
}