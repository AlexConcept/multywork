package com.example.data.backend

import com.example.data.backend.models.SkillResponse
import com.example.data.backend.models.UserResponse
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


val authenticator =
 AccessTokenAuthenticator("patoBqwV7bD2LmqcO.ccab139b63e5284fe678696862d7909803bd6ca763ecc89db6c9d2bb4121e45a")

private val retrofit = Retrofit.Builder()
 .baseUrl("https://api.airtable.com")
 .addConverterFactory(MoshiConverterFactory.create())
 .client(getRetrofitClient(authenticator))
 .build()

class AccessTokenAuthenticator(private val airtableApiToken: String) : Authenticator {
 override fun authenticate(route: Route?, response: Response): Request? {
  if (response.authenticatedWithSameToken(airtableApiToken)) {
   return null
  }
  return response.request.newBuilder()
   .addHeader("Authorization", "Bearer $airtableApiToken")
   .addHeader("Accept", "application/json")
   .build()
 }

 private fun Response.authenticatedWithSameToken(token: String): Boolean =
  header("Authorization with same token", "")?.endsWith(token) ?: true
}

private fun getRetrofitClient(authenticator: Authenticator? = null): OkHttpClient {

 return OkHttpClient.Builder()
  .addInterceptor { chain ->
   chain.proceed(chain.request().newBuilder().also {
    it.addHeader("Accept", "application/json")
   }.build())
  }.also { client ->
   authenticator?.let { client.authenticator(it) }
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    client.addInterceptor(logging)
  }.build()
}

interface ApiService {

 @GET("/v0/app4aX6ktUiVTBfP9/Skills?maxRecords=31&view=Grid%20view")
 suspend fun getSkills(): SkillResponse

 @GET("v0/appcFqmvhlbjJ23bU/Users/")
 suspend fun getUserById(
  @Query("id") id: String,
 ): UserResponse

 object ApiObject {
  val retrofitService: ApiService = retrofit.create(ApiService::class.java)
 }
}