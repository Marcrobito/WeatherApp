package mx.marcrobito.weatherapp.network

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "65d00499677e59496ca2f318eb68c049"

interface OpenWeatherMapService {
    @GET("forecast?appid=$API_KEY")
    suspend fun getForecastForCity(@Query("q") city:String):OpenWeatherMapResult
}