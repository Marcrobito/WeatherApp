package mx.marcrobito.weatherapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import mx.marcrobito.weatherapp.R
import mx.marcrobito.weatherapp.databinding.FragmentWeatherDetailBinding


class WeatherDetailFragment : Fragment() {

    private val viewModel:MainViewModel by activityViewModels()
    private lateinit var binding: FragmentWeatherDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeatherDetailBinding.inflate(inflater, container, false)
        with(binding){

            viewModel.reading.observe(requireActivity()){
                it?.let {
                    temperatureTextView.text = it.main.temp.toInt().toString()
                    feelsLikeTextView.text = "Feels like: ${it.main.temp.toInt().toString()}"
                    weatherTextView.text = it.weather[0].main
                    weatherDescriptionTextView.text = it.weather[0].description
                }
            }

            return root
        }
    }
}