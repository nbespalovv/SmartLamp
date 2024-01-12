package com.example.smartlamp.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SampleService {

    @POST("state/on")
    suspend fun turnOn(): Response<Boolean>

    @POST("state/off")
    suspend fun turnOff(): Response<Boolean>


    @POST("color")
    suspend fun setColor(@Query("color") color: String): Response<Boolean>

    @GET("color/name_only")
    suspend fun getPossibleColors(): Response<List<String>>

    @GET("color/current")
    suspend fun getCurrentColor(): Response<String>
}