package com.example.weathermvvm.network

import android.app.Application
import com.example.weathermvvm.module.MainActivityFragmentModule
import com.example.weathermvvm.module.RetrofitModule
import com.example.weathermvvm.module.ViewModelModule
import com.example.weathermvvm.module.WeatherActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    RetrofitModule::class,
    ViewModelModule::class,
    WeatherActivityModule::class,
    MainActivityFragmentModule::class])
interface AppComponent : AndroidInjector<DaggerApplication>{    
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication?)
}

