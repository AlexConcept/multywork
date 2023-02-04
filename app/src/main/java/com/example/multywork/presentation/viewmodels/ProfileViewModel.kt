package com.example.multywork.presentation.viewmodels

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.domain.entity.UserProfile
import com.example.domain.usecases.GetUserProfileUseCase
import com.example.multywork.utils.App
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private var _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile>
        get() = _userProfile

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                val getUserProfileUseCase =
                (this[APPLICATION_KEY] as App).appContainer.getUserProfileUseCase
                ProfileViewModel(
                    getUserProfileUseCase = getUserProfileUseCase,
                    savedStateHandle = savedStateHandle
                )
            }
        }
    }

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            _userProfile.value = getUserProfileUseCase.execute()
        }
    }
}