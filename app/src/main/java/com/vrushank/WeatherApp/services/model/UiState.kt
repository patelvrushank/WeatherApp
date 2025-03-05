package com.vrushank.WeatherApp.services.model

data class UiState(
    val feelslike: Int? = null,
    val humidity: Int? = null,
    val precip: Int? = null,
    val pressure: Int? = null,
    val temperature: Int? = null,
    val uv_index: Int? = null,
    val visibility: Int? = null,
    val weather_code: Int? = null,
    val wind_degree: Int? = null,
    val wind_dir: String? = null,
    val wind_speed: Int? = null,
    val country: String? = null,
    val localtime: String? = null,

)
