package com.example.offzmi.repository.backend

import com.example.offzmi.BuildConfig
import com.example.offzmi.R
import com.example.offzmi.repository.backend.models.UserDto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.Flow
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "${R.string.BASE_URL}"
private const val AIRTABLE_TOKEN = "${R.string.TOKEN}"

private val moshi = Moshi.Builder()
 .add(KotlinJsonAdapterFactory())
 .build()

val authenticator = AccessTokenAuthenticator(AIRTABLE_TOKEN)
private val retrofit = Retrofit.Builder()
 .addConverterFactory(MoshiConverterFactory.create(moshi))
 .baseUrl(BASE_URL)
 .client(getRetrofitClient(authenticator))
 .build()


class AccessTokenAuthenticator(val airtableApiToken: String) : Authenticator {
 override fun authenticate(route: Route?, response: Response): Request? {

  if (response.authenticatedWithSameToken(airtableApiToken)) {
   return null
  }

  return response.request.newBuilder()
   .addHeader("Authorization", "Bearer $airtableApiToken")
   .build()
 }


 fun Response.authenticatedWithSameToken(token: String): Boolean =
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
 ): List<UserDto>

 @GET("v0/appcFqmvhlbjJ23bU/Users/recocTGkklHkCXetE")
 suspend fun getUserById(
  @Query("id") id: Int,
 ): Flow<UserDto>
}

object ApiObject {
 val retrofitService: ApiService by lazy {
  retrofit.create(ApiService::class.java)
 }
}








