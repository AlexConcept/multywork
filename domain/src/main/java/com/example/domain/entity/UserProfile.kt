package com.example.domain.entity

data class  UserProfile (
 val avatarBase64: String,
 val company: String,
 val firstName: String,
 val lastName: String,
 val position: String,
 val rating: Int,
 val role: String,
 val verified: String,
 val id: Int,
)

