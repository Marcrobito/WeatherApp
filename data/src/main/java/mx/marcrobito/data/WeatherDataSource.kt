package mx.marcrobito.data

import mx.marcrobito.domain.WeatherReading

interface WeatherDataSource {
    suspend fun getWeatherByCity(city:String):Response<List<WeatherReading>>
}