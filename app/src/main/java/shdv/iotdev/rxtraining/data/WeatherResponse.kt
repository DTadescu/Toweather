package shdv.iotdev.rxtraining.data

import com.google.gson.annotations.SerializedName

data class WeatherResponse(

    val coord : Coord? = null,
    val weather : List<Weather>? = null,
    val base : String? = null,
    val main : Main? = null,
    val visibility : Int? = null,
    val wind : Wind? = null,
    val rain : Rain? = null,
    val clouds : Clouds? = null,
    val dt : Int? = null,
    val sys : Sys? = null,
    val timezone : Int? = null,
    val id : Int? = null,
    val name : String? = null,
    val cod : Int? = null
)

data class Coord (

    val lon : Double? = null,
    val lat : Double? = null
)

data class Clouds (

    val all : Int? = null
)

data class Main (

    val temp : Double? = null,
    val feels_like : Double? = null,
    val temp_min : Double? = null,
    val temp_max : Double? = null,
    val pressure : Int? = null,
    val humidity : Int? = null
)

data class Rain (

    @SerializedName("1h")
    val _1h : Double? = null
)

data class Sys (

    val type : Int? = null,
    val id : Int? = null,
    val country : String? = null,
    val sunrise : Int? = null,
    val sunset : Int? = null
)

data class Weather (

    val id : Int? = null,
    val main : String? = null,
    val description : String? = null,
    val icon : String? = null
)

data class Wind (

    val speed : Double? = null,
    val deg : Int? = null,
    val gust : Double? = null
)