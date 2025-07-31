package com.example.weatherapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
* Composable: it's what it tells the Android that this function draws UI (interface)
* MainScreen: it's the name I gave to my screen.
* Inside the function, I'll use components like como Text, Button, Column, etc., to build the layout.
*/
@Composable
fun MainScreen() {
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
            text = "Lisbon",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "25ºC",
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Clear",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Forecast List (hardcoded)
        val forecastList = listOf(
            Forecast("Monday", "☀️", 28, 17),
            Forecast("Tuesday", "🌤️", 27, 18),
            Forecast("Wednesday", "⛅", 26, 16),
            Forecast("Thursday", "☀️", 24, 15)
        )
        // Showing the forecast
        ForecastSection(forecastList) // Call the ForecastSection function and sends the data
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            /* empty for now */
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