package com.example.offzmi.domain

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.offzmi.repository.AppRepository
import com.example.offzmi.repository.backend.models.UserResponse
import com.example.offzmi.utils.App
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val repository: AppRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _userProfile = MutableLiveData<UserResponse>()
    val userProfile: LiveData<UserResponse>
        get() = _userProfile

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
    }

    private fun getUser() {
        viewModelScope.launch {
            _userProfile.value = repository.getUserProfile()
        }
    }
}