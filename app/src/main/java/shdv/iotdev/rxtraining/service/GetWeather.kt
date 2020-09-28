package shdv.iotdev.rxtraining.service

import io.reactivex.Observable
import shdv.iotdev.rxtraining.data.WeatherResponse

class GetWeather {

    val  apiService: OpenWeatherMapApiService = OpenWeatherMapApiService.create()

    fun getCurrentById(id: Int): Observable<WeatherResponse> = apiService.currentById(id = id)

    fun getCurrentByCity(city: String): Observable<WeatherResponse> = apiService.currentByCity(cityName = city)
}