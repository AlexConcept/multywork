package com.example.offzmi.domain

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.offzmi.repository.AppRepository
import com.example.offzmi.repository.backend.models.UserDto
import com.example.offzmi.utils.App
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val repository: AppRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _userProfile = MutableLiveData<UserDto>()
    val userProfile: LiveData<UserDto>
        get() = _userProfile

    private var _verificationUser: Boolean = false
    val verificationUser: Boolean
        get() = _verificationUser

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                val userRepository = (this[APPLICATION_KEY] as App).appContainer.userRepository
                ProfileViewModel(
                    repository = userRepository,
                    savedStateHandle = savedStateHandle
                )
            }
        }
    }

    init {
        getUser()
        getUserVerification()
    }

    private fun getUser() {
        viewModelScope.launch {
            _userProfile.value = repository.getUserProfile().value
        }
    }

    private fun getUserVerification() {
        viewModelScope.launch {
            if (_userProfile.value?.verified != false) {
                _verificationUser = true
            }
        }
    }
}