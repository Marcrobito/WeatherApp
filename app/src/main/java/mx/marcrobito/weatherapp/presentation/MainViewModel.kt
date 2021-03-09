package mx.marcrobito.weatherapp.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import mx.marcrobito.usecases.GetWeatherByCity
import kotlinx.coroutines.launch
import mx.marcrobito.data.Response
import mx.marcrobito.domain.WeatherReading
import java.lang.Exception
import javax.inject.Inject

class MainViewModel  @Inject constructor(private val getWeatherByCity: GetWeatherByCity): ViewModel() {

    private val _weather = MutableLiveData<Response<List<WeatherReading>>>(Response.NotInitialized)
    val weather : MutableLiveData<Response<List<WeatherReading>>> get() = _weather

    private val _city = MutableLiveData<String?>(null)
    val city : MutableLiveData<String?> get() = _city

    private val _reading = MutableLiveData<WeatherReading?>(null)
    val reading : MutableLiveData<WeatherReading?> get() = _reading

    fun getWeather(cityName: String) = viewModelScope.launch {
        weather.value = Response.Loading
        weather.value = getWeatherByCity.invoke(cityName)
        if(weather.value is Response.Success)
            _city.value = cityName
    }

    fun firstScreenVisible(){
        _city.value = null
    }

    fun findWeatherDetail(id:Long){
        try {
            reading.value = (weather.value as Response.Success<List<WeatherReading>>).data.filter {
                it.timestamp == id
            }[0]
        }catch (e:Exception){
            reading.value = null
        }
    }
}