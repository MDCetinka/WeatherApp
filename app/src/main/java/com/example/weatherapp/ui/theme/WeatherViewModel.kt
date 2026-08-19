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
    //mutable == değişebilir, stream of data, _backing propertyler içinmiş
    // veriyi dış müdahalelerden korumak için.
//null initializelanıyor daha data gelmeden böylece UI yüklenme ekranı vs gösterebilir


    val weatherData: StateFlow<WeatherResponse?> = _weatherData //immutable
//public, read-only versiyon. UI (Activity, fragment veya Jetpack compose ekranı)
//UI weatherDataya bakacak, private ve değişken _weatherData kenarda dursun
//immutable olduğu için UI statei modifiye etmeyecek

    private val weatherApi = WeatherApi.create()
    //sadece bu ViewModel network request yapabilsin diye instance of API service



    fun fetchWeather(city: String, apiKey: String){
        viewModelScope.launch{ //Kotlin Coroutine launchluyor.
        //Main UI threadde network call yapamazsın.
            //Bu sayesinde Viewmodel destroylanırsa (user ekranı kapatırsa)
            //background work de otomatik cancellansın, memory leak olmasın

            try{ //internet kopması server crashlemesi

                val response = weatherApi.getWeather(city, apiKey)
            //network requesti yapan.
            //The coroutine will "suspend" (pause) on this line
            //until the server responds, without blocking the main UI thread


                _weatherData.value = response
            //response gelince mutablestateflowumuz updateleniyor
            //UI de weatherDatanın değiştiğini görüp ekranı updateliyor


            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}