package com.example.offzmi.repository.backend.models

import com.squareup.moshi.Json


data class OldUserDto(

    @field:Json(name = "avatar_base_64") val avatarBase64: String,
    @field:Json(name = "company") val company: String,
    @field:Json(name = "first_name") val firstName: String,
    @field:Json(name = "last_name") val lastName: String,
    @field:Json(name = "position") val position: String,
    @field:Json(name = "rating") val rating: Int,
    @field:Json(name = "role") val role: String,
    @field:Json(name = "verified") var verified: Boolean,
    @field:Json(name = "id") val id: Int,
)

