package com.example.smartlamp.domain

import com.example.smartlamp.repository.SampleRepository
import javax.inject.Inject

class TurnOnUseCaseImpl @Inject constructor(
    val repository: SampleRepository
): TurnOnUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.turnOn()
}