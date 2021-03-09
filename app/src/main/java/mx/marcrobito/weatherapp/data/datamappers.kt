package mx.marcrobito.weatherapp.data

import mx.marcrobito.domain.*
import mx.marcrobito.weatherapp.network.*
import mx.marcrobito.domain.WeatherReading as DomainWeatherReading
import mx.marcrobito.domain.WeatherMain as DomainWeatherMain
import mx.marcrobito.domain.Weather as DomainWeather
import mx.marcrobito.domain.Clouds as DomainClouds
import mx.marcrobito.domain.Wind as DomainWind
import mx.marcrobito.domain.Sys as DomainSys

fun WeatherReading.toDomainWeatherReading(): DomainWeatherReading =
    DomainWeatherReading(
        timestamp,
        main.toDomainWeatherMain(),
        weather.map{ it.toDomainWeather() },
        clouds.toDomainClouds(),
        wind.toDomainWind(),
        visibility,
        pop,
        sys.toDomainSys(),
        date
    )

fun WeatherMain.toDomainWeatherMain(): DomainWeatherMain =
    DomainWeatherMain(
        temp,
        feelsLike,
        tempMin,
        tempMax,
        pressure,
        seaLevel,
        groundLevel,
        humidity,
        tempKf
    )

fun Weather.toDomainWeather(): DomainWeather =
    DomainWeather( id, main, description, icon )

fun Clouds.toDomainClouds(): DomainClouds =
    DomainClouds(all)

fun Wind.toDomainWind(): DomainWind =
    DomainWind(speed, deg)

fun Sys.toDomainSys(): DomainSys =
    DomainSys(pod)
