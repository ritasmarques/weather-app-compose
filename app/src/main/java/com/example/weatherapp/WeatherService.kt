package com.example.weatherapp

import retrofit2.http.GET
import retrofit2.http.Query

// Defines the API's interface
interface WeatherService {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String="metric"
    ): WeatherResponse
}