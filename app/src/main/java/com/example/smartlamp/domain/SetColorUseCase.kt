package com.example.smartlamp.domain

interface SetColorUseCase {
    suspend operator fun invoke(color: String): Result<Boolean?>
}