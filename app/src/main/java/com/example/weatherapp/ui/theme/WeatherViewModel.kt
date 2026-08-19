package com.example.weatherapp.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.WeatherApi
import com.example.weatherapp.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel(){ //extending viewmodel, UI related data,
    //ekranı yan döndürmek gibi konfigürasyon değişimlerinde data yamulmasın
    private val _weatherData = MutableStateFlow<WeatherResponse?>(null)
    //mutable == değişebilir, stream of data, _backing propertyler içinmiş.
//null initializelanıyor daha data gelmeden böylece UI yüklenme ekranı vs gösterebilir

    val weatherData: StateFlow<WeatherResponse?> = _weatherData
    
    private val weatherApi = WeatherApi.create()

    fun fetchWeather(city: String, apiKey: String){
        viewModelScope.launch{
            try{
                val response = weatherApi.getWeather(city, apiKey)
                _weatherData.value = response
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}