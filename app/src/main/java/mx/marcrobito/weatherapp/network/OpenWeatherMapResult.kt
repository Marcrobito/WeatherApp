package mx.marcrobito.weatherapp.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OpenWeatherMapResult(
    @Json(name = "cod")
    val httpCodeResult:Int,
    @Json(name = "message")
    val message:Int,
    @Json(name = "cnt")
    val results:Int,
    @Json(name = "list")
    val readings:List<WeatherReading>,
    @Json(name = "city")
    val city:City
)

@JsonClass(generateAdapter = true)
data class WeatherReading(
    @Json(name = "dt")
    val timestamp:Long,
    @Json(name = "main")
    val main:WeatherMain,
    @Json(name = "weather")
    val weather:List<Weather>,
    @Json(name = "clouds")
    val clouds:Clouds,
    @Json(name = "wind")
    val wind:Wind,
    @Json(name = "visibility")
    val visibility:Int,
    @Json(name = "pop")
    val pop:Double,
    @Json(name = "sys")
    val sys:Sys,
    @Json(name = "dt_txt")
    val date:String
)

@JsonClass(generateAdapter = true)
data class WeatherMain(
    @Json(name = "temp")
    val temp:Double,
    @Json(name = "feels_like")
    val feelsLike:Double,
    @Json(name = "temp_min")
    val tempMin:Double,
    @Json(name = "temp_max")
    val tempMax:Double,
    @Json(name = "pressure")
    val pressure:Int,
    @Json(name = "sea_level")
    val seaLevel:Int,
    @Json(name = "grnd_level")
    val groundLevel:Int,
    @Json(name = "humidity")
    val humidity:Int,
    @Json(name = "temp_kf")
    val tempKf:Double
)

@JsonClass(generateAdapter = true)
data class Weather(
    @Json(name = "id")
    val id:Int,
    @Json(name = "main")
    val main:String,
    @Json(name = "description")
    val description:String,
    @Json(name = "icon")
    val icon:String
)

@JsonClass(generateAdapter = true)
data class Clouds(
    @Json(name = "all")
    val all:Int
)

@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "speed")
    val speed:Double,
    @Json(name = "deg")
    val deg:Int
)

@JsonClass(generateAdapter = true)
data class Sys(
    @Json(name = "pod")
    val pod:String
)

@JsonClass(generateAdapter = true)
data class City(
    @Json(name = "id")
    val id:Int,
    @Json(name = "name")
    val name:String,
    @Json(name = "coord")
    val coordinate: Coordinate,
    @Json(name = "country")
    val country:String,
    @Json(name = "population")
    val population:Int,
    @Json(name = "timezone")
    val timezone:Int,
    @Json(name = "sunrise")
    val sunrise:Int,
    @Json(name = "sunset")
    val sunset:Int
)

@JsonClass(generateAdapter = true)
data class Coordinate(
    @Json(name = "lat")
    val latitude:Double,
    @Json(name = "lon")
    val longitude:Double,
)

