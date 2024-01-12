package com.example.smartlamp.domain

interface GetPossibleColorsUseCase {
    suspend operator fun invoke(): Result<List<String>?>
}