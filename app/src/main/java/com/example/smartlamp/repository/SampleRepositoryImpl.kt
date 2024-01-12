package com.example.smartlamp.repository

import com.example.smartlamp.api.SampleService
import retrofit2.HttpException
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val service: SampleService,
) : SampleRepository {

    override suspend fun turnOn(): Result<Boolean?> {
        kotlin.runCatching {
            service.turnOn()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun turnOff(): Result<Boolean?> {
        kotlin.runCatching {
            service.turnOff()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun setColor(color: String): Result<Boolean?> {
        kotlin.runCatching {
            service.setColor(color)
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }


    override suspend fun getPossibleColors(): Result<List<String>?> {
        kotlin.runCatching {
            service.getPossibleColors()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getCurrentColor(): Result<String?> {
        return runCatching {
            val response = service.getCurrentColor()
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(HttpException(response))
            }
        }.getOrElse {
            Result.failure(it)
        }
    }

}
