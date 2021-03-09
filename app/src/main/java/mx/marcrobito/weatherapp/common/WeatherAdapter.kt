package mx.marcrobito.weatherapp.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.marcrobito.domain.WeatherReading
import mx.marcrobito.weatherapp.databinding.ItemWeatherBinding

class WeatherAdapter(private val list: List<WeatherReading>, private val listener:WeatherListListener):RecyclerView.Adapter<WeatherAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding, listener)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class VH(private val binding: ItemWeatherBinding, private val listener:WeatherListListener):RecyclerView.ViewHolder(binding.root){
        fun bind(reading: WeatherReading){
            with(binding){
                temperature.text = "Temp: ${reading.main.temp}"
                weather.text = reading.weather[0].main
                Glide.with(icon).load("https://openweathermap.org/img/w/${reading.weather[0].icon}.png").into(icon)
                root.setOnClickListener {
                    listener.onWeatherSelected(reading.timestamp)
                }
            }
        }
    }
}

interface WeatherListListener {
    fun onWeatherSelected(id: Long)
}