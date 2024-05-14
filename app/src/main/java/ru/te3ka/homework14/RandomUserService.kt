package ru.te3ka.homework14

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://randomuser.me/"

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val randomUserService: RandomUserService = retrofit.create(RandomUserService::class.java)
}

interface RandomUserService {
    @GET("api/")
    fun getRandomUser(): Call<UserResponse>
}