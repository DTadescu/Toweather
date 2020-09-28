package shdv.iotdev.rxtraining.service

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import shdv.iotdev.rxtraining.data.WeatherResponse

interface OpenWeatherMapApiService {

    @GET("data/2.5/{type}")
    fun currentById(
        @Path("type") type: String = "weather",
        @Query("id") id: Int,
        @Query("appid") appId: String = "4e29e5fbf0d457fb9effe1cb99227f70",
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "ru"
    ):Observable<WeatherResponse>

    @GET("data/2.5/{type}")
    fun currentByCity(
        @Path("type") type: String = "weather",
        @Query("q") cityName: String,
        @Query("appid") appId: String = "4e29e5fbf0d457fb9effe1cb99227f70",
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "ru"
    ):Observable<WeatherResponse>

    companion object Factory{
        fun create(): OpenWeatherMapApiService = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/")
            .build()
            .create(OpenWeatherMapApiService::class.java)
    }
}