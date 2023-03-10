package com.example.data.backend.models

import com.squareup.moshi.Json

data class UserFields(
    @Json(name = "avatar_base_64") val avatarBase64: String,
    @Json(name = "company") val company: String,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "position") val position: String,
    @Json(name = "rating") val rating: Int,
    @Json(name = "role") val role: String,
    @Json(name = "verified") val verified: String,
    @Json(name = "id") val id: Int,
)