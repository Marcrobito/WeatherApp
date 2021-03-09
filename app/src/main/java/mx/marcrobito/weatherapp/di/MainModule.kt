package mx.marcrobito.weatherapp.di

import dagger.Module
import dagger.Provides
import mx.marcrobito.data.WeatherDataSource
import mx.marcrobito.data.WeatherRepository
import mx.marcrobito.usecases.GetWeatherByCity
import mx.marcrobito.weatherapp.data.WeatherApiDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Module
class MainModule {

    @Provides
    @Singleton
    fun providesWeatherDataSource():WeatherDataSource = WeatherApiDataSource()

    @Provides
    @Inject
    @Singleton
    fun providesWeatherRepository(dataSource: WeatherDataSource) = WeatherRepository(dataSource)

    @Provides
    @Inject
    @Singleton
    fun providesGetWeatherByCity(repository: WeatherRepository) = GetWeatherByCity(repository)
}