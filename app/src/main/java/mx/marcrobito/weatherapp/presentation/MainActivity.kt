package mx.marcrobito.weatherapp.presentation

import android.view.View
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import mx.marcrobito.data.Response.*
import mx.marcrobito.weatherapp.App
import mx.marcrobito.weatherapp.R
import mx.marcrobito.weatherapp.databinding.ActivityMainBinding
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory
    private lateinit var viewModel:MainViewModel

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).component.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, viewModelProvider).get(MainViewModel::class.java)

        with(binding){

            setContentView(root)

            backArrow.setOnClickListener {
                this@MainActivity.onBackPressed()
            }

            viewModel.weather.observe(this@MainActivity){
                when(it){
                    is NotInitialized -> {}
                    is Loading -> loader.visibility = View.VISIBLE
                    is Fail -> {
                        loader.visibility = View.GONE
                        Toast.makeText(this@MainActivity,"Error", Toast.LENGTH_SHORT).show()
                    }
                    is Success -> {
                        loader.visibility = View.GONE
                        Toast.makeText(this@MainActivity,"Error", Toast.LENGTH_SHORT).show()
                        findNavController(navHostFragment).navigate(R.id.action_searchByCityFragment_to_weatherListFragment)
                    }
                    else -> {}
                }
            }

            viewModel.city.observe(this@MainActivity){
                if(it != null){
                    appBarLayout.visibility = View.VISIBLE
                    cityNameTextView.text = it
                    return@observe
                }
                appBarLayout.visibility = View.GONE
            }

            viewModel.reading.observe(this@MainActivity) {
                it?.let {
                    findNavController(navHostFragment).navigate(R.id.action_weatherListFragment_to_weatherDetailFragment, null)
                }
            }
        }

    }

}