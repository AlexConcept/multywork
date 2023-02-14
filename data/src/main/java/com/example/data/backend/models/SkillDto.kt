package com.example.data.backend.models

import com.squareup.moshi.Json

data class SkillDto(
    @Json(name = "createdTime") val createdTime: String,
    @Json(name = "userFields") val skillFields: SkillFields,
    @Json(name = "id") val id: String,
)