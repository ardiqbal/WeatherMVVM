package com.example.weathermvvm.module

import com.example.weathermvvm.network.OpenWeatherApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [OkHttpClientModule::class])
class RetrofitModule {
    @Provides @Singleton
    fun provideOpenWeatherApi(retrofit: Retrofit) : OpenWeatherApi {
        return retrofit.create(OpenWeatherApi::class.java)
    }

    @Provides @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides @Singleton
    fun provideGson() : Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides @Singleton
    fun provideGsonConverterFactory(gson: Gson) : GsonConverterFactory = GsonConverterFactory.create(gson)
}