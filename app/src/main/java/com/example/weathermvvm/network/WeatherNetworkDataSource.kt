package com.example.weathermvvm.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weathermvvm.Constant
import com.example.weathermvvm.data.model.ResultWeather
import retrofit2.HttpException
import retrofit2.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherNetworkDataSource @Inject constructor(val openWeatherApi: OpenWeatherApi){
    private val TAG = WeatherNetworkDataSource::class.java.simpleName
    private val _downloadedCurrentWeatherData = MutableLiveData<ResultWeather>()

    val downloadedLiveData : LiveData<ResultWeather>
        get() = _downloadedCurrentWeatherData

    suspend fun fetchCurrentWeather(city: String){
        try{
            val response = openWeatherApi.getCurrentWeatherInfo(city, Constant.apiKey).await()
            _downloadedCurrentWeatherData.value = response
        }catch (e: Exception){
            Log.e(TAG, e.message)
        }
    }
}