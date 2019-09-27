package com.example.weathermvvm.network


import com.example.weathermvvm.data.model.ResultWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {
    @GET("data/2.5/weather?")
    fun getCurrentWeatherInfo(@Query("q") city: String, @Query("appid") apikey: String) : Call<ResultWeather>
}