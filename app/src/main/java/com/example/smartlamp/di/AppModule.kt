package com.example.smartlamp.di

import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        AppBindsModule::class,
        NetworkModule::class,
    ]
)
class AppModule {
}