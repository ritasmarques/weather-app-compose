package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme // pacote gerado automaticamente

// It's the apps starting point — when the user opens the app, it's here where all starts
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {    // This function it's called when the app opens
            // Gives the UI the theme of the app (colors, typography, fonts, etc)
            WeatherAppTheme {
                // Creates the app's UI
                Surface( // It's the "blank sheet" where we draw the UI
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()    // Calls our main screen function
                }
            }
        }
    }
}