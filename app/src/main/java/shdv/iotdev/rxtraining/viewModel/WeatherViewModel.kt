package shdv.iotdev.rxtraining.viewModel

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import shdv.iotdev.rxtraining.data.WeatherModel
import shdv.iotdev.rxtraining.data.toModel
import shdv.iotdev.rxtraining.databinding.ActivityMainBinding
import shdv.iotdev.rxtraining.service.GetWeatherProvider

class WeatherViewModel(
    private val binding: ActivityMainBinding
) {

    init {
        binding.weather = model
    }

    companion object{
        private var model = WeatherModel()
    }
    private val repository = GetWeatherProvider.provideGetWeather()


    fun getCurrentWeather(city: String){
        repository.getCurrentByCity(city)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                    result ->
                model = result.toModel()
                binding.weather = model
            }, {
                    error ->
                error.printStackTrace()
            }

            )
    }
}