package com.example.data.backend.models

import com.squareup.moshi.Json

data class UserDto(
    @Json(name = "createdTime") val createdTime: String,
    @Json(name = "userFields") val userFields: UserFields,
    @Json(name = "id") val id: String,
)