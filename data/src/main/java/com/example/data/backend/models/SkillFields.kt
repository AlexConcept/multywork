package com.example.data.backend.models

import com.squareup.moshi.Json

data class SkillFields(
   @Json(name = "id") val id: Int,
   @Json(name = "skillName") val skillName: String,
   @Json(name = "skillIconBase64") val skillIconBase64: String,
)