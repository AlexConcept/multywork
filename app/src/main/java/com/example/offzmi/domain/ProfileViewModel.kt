package com.example.offzmi.domain

import androidx.lifecycle.ViewModel
import com.example.offzmi.repository.AppRepository
import com.example.offzmi.repository.backend.models.UserDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel(private val repository: AppRepository, private val data: UserDto) : ViewModel() {



}