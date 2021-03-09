package mx.marcrobito.weatherapp.data

import android.util.Log
import mx.marcrobito.data.Response
import mx.marcrobito.data.WeatherDataSource
import mx.marcrobito.domain.WeatherReading
import mx.marcrobito.weatherapp.network.OpenWeatherMap
import javax.inject.Singleton

@Singleton
class WeatherApiDataSource : WeatherDataSource {

    override suspend fun getWeatherByCity(city: String): Response<List<WeatherReading>> {
        return try {
            val result = OpenWeatherMap.service
                .getForecastForCity(city).readings
                .map {
                    it.toDomainWeatherReading()
                }
            Response.Success(result)
        }catch (exception:Exception){
            Response.Fail(exception )
        }
    }

}