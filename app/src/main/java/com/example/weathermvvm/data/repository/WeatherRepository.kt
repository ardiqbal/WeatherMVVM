package com.example.weathermvvm.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.weathermvvm.data.model.ResultWeather
import com.example.weathermvvm.network.OpenWeatherApi
import com.example.weathermvvm.network.WeatherNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(val weatherNetworkDataSource: WeatherNetworkDataSource){

    suspend fun getCurrentWeatherData(city: String) : LiveData<ResultWeather>{
        weatherNetworkDataSource.fetchCurrentWeather(city)
        return withContext(Dispatchers.IO) {
            return@withContext weatherNetworkDataSource.downloadedLiveData
        }
    }
}