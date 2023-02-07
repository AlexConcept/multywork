package com.example.multywork.presentation.viewmodels

import androidx.lifecycle.*
import com.example.domain.entity.UserProfile
import com.example.domain.usecases.GetUserProfileUseCase
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserProfileUseCase: GetUserProfileUseCase,
) : ViewModel() {

    private var _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile>
        get() = _userProfile

//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val savedStateHandle = createSavedStateHandle()
//                val getUserProfileUseCase =
//                (this[APPLICATION_KEY] as App).appContainer.getUserProfileUseCase
//                ProfileViewModel(
//                    getUserProfileUseCase = getUserProfileUseCase,
//                    savedStateHandle = savedStateHandle
//                )
//            }
//        }
//    }
init {
    getUser()
}

    private fun getUser() {
        viewModelScope.launch {
            _userProfile.value = getUserProfileUseCase.execute()
        }
    }
}

class ProfileViewModelFactory(
    val getUserProfileUseCase: GetUserProfileUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(
            getUserProfileUseCase = getUserProfileUseCase
        ) as T
    }
}