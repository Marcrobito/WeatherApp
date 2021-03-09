package mx.marcrobito.domain

data class WeatherReading(
    val timestamp:Long,
    val main:WeatherMain,
    val weather:List<Weather>,
    val clouds:Clouds,
    val wind:Wind,
    val visibility:Int,
    val pop:Double,
    val sys:Sys,
    val date:String
)

data class WeatherMain(
    val temp:Double,
    val feelsLike:Double,
    val tempMin:Double,
    val tempMax:Double,
    val pressure:Int,
    val seaLevel:Int,
    val groundLevel:Int,
    val humidity:Int,
    val tempKf:Double
)

data class Weather(
    val id:Int,
    val main:String,
    val description:String,
    val icon:String
)

data class Clouds(
    val all:Int
)

data class Wind(
    val speed:Double,
    val deg:Int
)

data class Sys(
    val pod:String
)