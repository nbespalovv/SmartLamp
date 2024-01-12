package com.example.smartlamp.domain

import com.example.smartlamp.repository.SampleRepository
import javax.inject.Inject

class SetColorUseCaseImpl @Inject constructor(
    private val repository: SampleRepository
) : SetColorUseCase {
    override suspend fun invoke(color: String): Result<Boolean?> =
        repository.setColor(color)
}