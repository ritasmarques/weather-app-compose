package com.example.weatherapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val repository = WeatherRepository()

    var city by mutableStateOf("Lisbon")
    var temperature by mutableStateOf("")
    var description by mutableStateOf("")

    fun fetchWeather() {
        viewModelScope.launch {
            try {
                val response = repository.getWeather(city)
                temperature = "${response.main.temp.toInt()}ºC"
                description = response.weather.firstOrNull()?.description ?: "N/A"
            } catch (e: Exception) {
                temperature = "--"
                description = "Error obtaining data"
            }
        }
    }
}