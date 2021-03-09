package mx.marcrobito.usecases

import mx.marcrobito.data.Response
import mx.marcrobito.data.WeatherRepository
import mx.marcrobito.domain.WeatherReading

class GetWeatherByCity(private val repository: WeatherRepository) {
    suspend fun invoke(city: String): Response<List<WeatherReading>> = repository.getWeatherByCity(city)
}