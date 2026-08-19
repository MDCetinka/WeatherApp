package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.ui.theme.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


        }
    }
}

@Composable
fun WeatherScreen(){
    val viewModel: WeatherViewModel = viewModel()
    val weatherData by viewModel.weatherData.collectAsState()
    var city by remember{
        mutableStateOf("")
    }
    val apiKey = "123456789"
}

@Preview(showBackground = true)
@Composable
fun WeatherPreview(){
    TheWeatherAppTheme{
        WeatherScreen()
    }
}

@Composable
fun TheWeatherAppTheme(content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//Text( text = "Hello $name!", modifier = modifier ) }
//Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//WeatherAppTheme { Greeting("Android") } }