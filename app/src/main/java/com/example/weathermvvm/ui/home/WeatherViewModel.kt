package com.example.weathermvvm.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathermvvm.data.repository.WeatherRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    val weatherRepository: WeatherRepository
) : ViewModel() {

    suspend fun getCurrentWeather(city: String) = weatherRepository.getCurrentWeatherData(city)
}