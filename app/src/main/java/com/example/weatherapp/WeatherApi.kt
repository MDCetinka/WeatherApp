package com.example.weatherapp

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")

    //weather datayı fetchleyen fonksiyon
    //network requesti performladığı için suspend dedik (
    // should be called from a code routinemiş
    //URLdeki parametreleri tanımlamalıyız ki istediğimiz gibi değiştirelim
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse

    companion object{
        private const val BASE_fffffffffffURL = "https://api.openweathermap.org/data/2.5/"
    }


}