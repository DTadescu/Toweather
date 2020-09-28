package shdv.iotdev.rxtraining.data

fun WeatherResponse.toModel() = WeatherModel(
    city = name?:"",
    weatherDescription = weather?.let {
        it.first().description?:""
    }?:"",
    temperature = main?.temp.toTemperatureString(),
    pressure = main?.pressure.hPaToMmHg(),
    humidity = main?.humidity.stringHumidity(),
    windSpeed = wind?.speed.stringIntSpeed(),
    windDeg = wind?.deg.toDirection()
)

private fun Int?.stringHumidity():String =
    this?.let {
        it.toString() + " %"
    }?:""

private fun Double?.toTemperatureString():String =
    this?.let {
        if(it > 0)
            "+" + it.toInt().toString() + "\u00B0C"
        else
            it.toInt().toString() + "\u00B0C"
    }?:""


private fun Int?.hPaToMmHg():String =
     this?.let {
        (it/1.3332).toInt().toString() + " мм. рт. ст."
    }?:""

private fun Double?.stringIntSpeed():String =
     this?.let {
        it.toInt().toString() + " м/с"
    }?:""

private fun Int?.toDirection():String =
     when(this){
        in 0..23, in 337..360 -> "Ю"
        in 24..66 -> "ЮЗ"
        in 67..113 -> "З"
        in 114..156 -> "СЗ"
        in 157..203 -> "С"
        in 204..246 -> "СВ"
        in 247..293 -> "В"
        in 294..336 -> "ЮВ"
        else -> ""
    }
