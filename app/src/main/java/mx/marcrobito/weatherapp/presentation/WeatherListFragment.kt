package mx.marcrobito.weatherapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import mx.marcrobito.data.Response.Success
import mx.marcrobito.weatherapp.R
import mx.marcrobito.weatherapp.common.WeatherAdapter
import mx.marcrobito.weatherapp.common.WeatherListListener
import mx.marcrobito.weatherapp.databinding.FragmentWeatherListBinding


class WeatherListFragment : Fragment(), WeatherListListener {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentWeatherListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentWeatherListBinding.inflate(inflater, container, false)

        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        with(binding) {
            viewModel.weather.observe(requireActivity()) {
                if (it is Success)
                    with(recycler) {
                        layoutManager = manager
                        adapter = WeatherAdapter(it.data, this@WeatherListFragment)
                    }
            }


            return root
        }


    }

    override fun onWeatherSelected(id: Long) {
        viewModel.findWeatherDetail(id)
    }

}