package com.example.offzmi.repository.backend

import androidx.databinding.ktx.BuildConfig
import com.example.offzmi.repository.backend.models.OldUserDto
import com.example.offzmi.repository.backend.models.UserDto
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val authenticator =
 AccessTokenAuthenticator("patLjaA9PpxNgSK6z.0131f87279f385a422f27dd6ae2a5062c23e471e8f8e171999731760a74dfbbe")

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
   .build()
 }

 private fun Response.authenticatedWithSameToken(token: String): Boolean =
  header("Authorization with same token", "")?.endsWith(token) ?: false
}

private fun getRetrofitClient(authenticator: Authenticator? = null): OkHttpClient {
 return OkHttpClient.Builder()
  .addInterceptor { chain ->
   chain.proceed(chain.request().newBuilder().also {
    it.addHeader("Accept", "application/json")
   }.build())
  }.also { client ->
   authenticator?.let { client.authenticator(it) }
   if (BuildConfig.DEBUG) {
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    client.addInterceptor(logging)
   }
  }.build()
}

interface ApiService {

 @GET("/v0/appcFqmvhlbjJ23bU/Users?maxRecords=3&view=Grid%20view")
 suspend fun getUsers(
  @Query("id") id: Int,
  @Query("firstName") firstName: String,
  @Query("lastName") lastName: String,
  @Query("rating") rating: Int,
  @Query("verified") verified: String,
  @Query("avatarBase64") avatarBase64: String,
  @Query("company") company: String,
  @Query("position") position: String,
  @Query("role") role: String,
 ): List<OldUserDto>

 @GET("v0/appcFqmvhlbjJ23bU/Users/")
 suspend fun getUserById(
  @Query("id") id: String,
 ): UserDto

 object ApiObject {
  val retrofitService: ApiService by lazy {
   retrofit.create(ApiService::class.java)
  }
 }
}