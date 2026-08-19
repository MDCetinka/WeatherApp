package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


        }
    }
}

@Composable
fun WeatherScreen() {
    val viewModel: WeatherViewModel = viewModel()
    val weatherData by viewModel.weatherData.collectAsState()
    var city by remember {
        mutableStateOf("")
    }
    val apiKey = "123456789"


    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
                Spacer(modifier = Modifier.height(180.dp))
                OutlinedTextField(value = city,
                onValueChange = {city = it},
                label = {Text("City")},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.colors(

                )
                )
        }
    }

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