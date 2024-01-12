package com.example.smartlamp.domain

import com.example.smartlamp.repository.SampleRepository
import javax.inject.Inject

class TurnOffUseCaseImpl @Inject constructor(
    val repository: SampleRepository
): TurnOffUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.turnOff()
}