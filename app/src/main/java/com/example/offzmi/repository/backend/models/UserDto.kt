package com.example.offzmi.repository.backend.models

import com.squareup.moshi.Json

data class UserDto(
    @Json(name = "createdTime") val createdTime: String,
    @Json(name = "fields") val fields: Fields,
    @Json(name = "id") val id: String,
)