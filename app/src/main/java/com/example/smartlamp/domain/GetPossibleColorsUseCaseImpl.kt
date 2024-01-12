package com.example.smartlamp.domain

import com.example.smartlamp.repository.SampleRepository
import javax.inject.Inject

class GetPossibleColorsUseCaseImpl @Inject constructor(
    private val repository: SampleRepository
) : GetPossibleColorsUseCase {
    override suspend fun invoke(): Result<List<String>?> =
        repository.getPossibleColors()
}