package com.example.smartlamp.domain

interface GetCurrentColorUseCase {
    suspend operator fun invoke(): Result<String?>
}