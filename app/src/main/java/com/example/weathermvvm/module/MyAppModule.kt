package com.example.weathermvvm.module

import android.app.Application
import com.example.weathermvvm.MyApplication
import dagger.Binds
import dagger.Module

@Module
abstract class MyAppModule {

    @Binds
    abstract fun application (app : MyApplication): Application
}