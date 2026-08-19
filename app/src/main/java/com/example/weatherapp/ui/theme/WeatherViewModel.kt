package com.example.weatherapp.ui.theme

import androidx.lifecycle.ViewModel
import com.example.weatherapp.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow

class WeatherViewModel : ViewModel(){ //extending viewmodel
    private val _weatherData = MutableStateFlow<WeatherResponse?>(null)

}