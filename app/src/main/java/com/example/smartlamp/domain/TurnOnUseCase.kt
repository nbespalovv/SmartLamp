package com.example.smartlamp.domain

interface TurnOnUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}