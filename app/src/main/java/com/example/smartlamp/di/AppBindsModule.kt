package com.example.smartlamp.di

import GetCurrentColorUseCaseImpl
import com.example.smartlamp.domain.GetCurrentColorUseCase
import com.example.smartlamp.domain.GetPossibleColorsUseCase
import com.example.smartlamp.domain.GetPossibleColorsUseCaseImpl
import com.example.smartlamp.domain.SetColorUseCase
import com.example.smartlamp.domain.SetColorUseCaseImpl
import com.example.smartlamp.domain.TurnOffUseCase
import com.example.smartlamp.domain.TurnOffUseCaseImpl
import com.example.smartlamp.domain.TurnOnUseCase
import com.example.smartlamp.domain.TurnOnUseCaseImpl
import com.example.smartlamp.repository.SampleRepository
import com.example.smartlamp.repository.SampleRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindSampleRepository(repository: SampleRepositoryImpl): SampleRepository

    @Binds
    fun bindTurnOnUseCase(useCase: TurnOnUseCaseImpl): TurnOnUseCase

    @Binds
    fun bindTurnOffUseCase(useCase: TurnOffUseCaseImpl): TurnOffUseCase

    @Binds
    fun bindSetColorUseCase(useCase: SetColorUseCaseImpl): SetColorUseCase

    @Binds
    fun bindGetPossibleColorsUseCase(useCase: GetPossibleColorsUseCaseImpl): GetPossibleColorsUseCase

    @Binds
    fun bindGetCurrentColorUseCase(useCase: GetCurrentColorUseCaseImpl): GetCurrentColorUseCase
}