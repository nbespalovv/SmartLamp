package com.example.smartlamp.domain

interface TurnOffUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}