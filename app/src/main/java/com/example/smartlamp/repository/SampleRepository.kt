package com.example.smartlamp.repository

interface SampleRepository {

    suspend fun turnOn(): Result<Boolean?>
    suspend fun turnOff(): Result<Boolean?>
    suspend fun setColor(color: String): Result<Boolean?>
    suspend fun getPossibleColors(): Result<List<String>?>
    suspend fun getCurrentColor(): Result<String?>
}