package com.example.weathermvvm.module

import com.example.weathermvvm.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class WeatherActivityModule{
    @ContributesAndroidInjector(modules= [MainActivityFragmentModule::class])
    internal abstract fun bindMainActivity(): MainActivity
}