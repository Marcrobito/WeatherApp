package mx.marcrobito.data

class WeatherRepository(private val dataSource: WeatherDataSource ) {
    suspend fun getWeatherByCity(city:String) = dataSource.getWeatherByCity(city)
}