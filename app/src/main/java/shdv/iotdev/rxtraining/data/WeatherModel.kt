package shdv.iotdev.rxtraining.data

data class WeatherModel(
    val city: String = "",
    val weatherDescription: String = "",
    val temperature: String = "",
    val pressure: String = "",
    val humidity: String = "",
    val windSpeed: String = "",
    val windDeg: String = ""
)