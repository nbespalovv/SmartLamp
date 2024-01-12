package com.example.smartlamp.di

import com.example.smartlamp.presenter.sample.SampleFragment
import dagger.Component

@Component(
    modules = [
        AppModule::class,
    ]
)
interface AppComponent {

    fun inject(fragment: SampleFragment)
}