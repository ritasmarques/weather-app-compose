package com.example.weatherapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

/*
* Composable: it's what it tells the Android that this function draws UI (interface)
* MainScreen: it's the name I gave to my screen.
* Inside the function, I'll use components like como Text, Button, Column, etc., to build the layout.
*/
@Composable
fun MainScreen(viewModel: WeatherViewModel = viewModel()) {
    LaunchedEffect(Unit) {
        viewModel.fetchWeather()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        /* Modifier.fillMaxSize() → occupies the whole screen
           padding(16.dp) → gives an interior margin of 16 “points” (density-independent pixels)
           verticalArrangement.Center → centres the elements in the middles vertically
           horizontalAlignment.CenterHorizontally → centres in the horizontal axle */
    ){
        Text(
            text = viewModel.city,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = viewModel.temperature,
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = viewModel.description,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            viewModel.fetchWeather()
        }) {
            Text("Refresh")
        }
    }
}

/*
A data class it's a way of saving data with "name"
In this case, each forecast it's gonna have: day, max temp, min temp and an icon
*/
data class Forecast(
    val day: String,
    val icon: String,
    val maxTemp: Int,
    val minTemp: Int
)

@Composable
// Draws the “table” of forecasts with a Row() per day
fun ForecastSection(forecastList: List<Forecast>) {
    Column {
        forecastList.forEach { forecast -> // Runs the list and draws a row per forecast
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = forecast.day)
                Text(text = forecast.icon, fontSize = 18.sp)
                Text(text = "${forecast.maxTemp}º")
                Text(text = "${forecast.minTemp}º")
            }
        }
    }
}