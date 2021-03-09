package mx.marcrobito.weatherapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import mx.marcrobito.weatherapp.common.BaseFragment
import mx.marcrobito.weatherapp.databinding.FragmentSearchByCityBinding


class SearchByCityFragment : BaseFragment() {

    private val viewModel:MainViewModel by activityViewModels()
    private lateinit var binding: FragmentSearchByCityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchByCityBinding.inflate(inflater, container, false)
        with(binding){

            getCityWeatherButton.setOnClickListener {
                hideKeyboardFrom(requireActivity(), it)
                getWeather(cityNameEditText.text.toString())
            }

            return root
        }
    }

    override fun onResume() {
        super.onResume()
        binding.cityNameEditText.setText("")
        viewModel.firstScreenVisible()
    }

    private fun  getWeather(city:String){
        if (city == ""){
            Toast.makeText(requireActivity(),"Please provide a city", Toast.LENGTH_SHORT).show()
            return
        }
        viewModel.getWeather(city)
    }

}