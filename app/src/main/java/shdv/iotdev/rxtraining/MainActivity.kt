package shdv.iotdev.rxtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import shdv.iotdev.rxtraining.data.WeatherModel
import shdv.iotdev.rxtraining.databinding.ActivityMainBinding
import shdv.iotdev.rxtraining.service.GetWeatherProvider
import shdv.iotdev.rxtraining.viewModel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        weatherViewModel = WeatherViewModel(binding)
        queryCityButton.setOnClickListener {
            weatherViewModel.getCurrentWeather(inputCity.text.toString())
        }


    }
}