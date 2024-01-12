package com.example.smartlamp.di

import com.example.smartlamp.api.SampleService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun provideSampleService(): SampleService =
        Retrofit.Builder()
            .baseUrl("http://195.54.14.121:8086/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SampleService::class.java)
}