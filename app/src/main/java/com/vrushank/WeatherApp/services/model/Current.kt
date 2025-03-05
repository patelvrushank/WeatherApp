package com.vrushank.WeatherApp.services.model



data class Current(
    val cloudcover: Int?= 0,
    val feelslike: Int? = 0,
    val humidity: Int? = 0,
    val observation_time: String ?= null,
    val precip: Int ?= 0,
    val pressure: Int ? = 0,
    val temperature: Int ?= 0,
    val uv_index: Int? = 0,
    val visibility: Int? = 0,
    val weather_code: Int? = 0,
    val weatherDescriptions: List<String> = emptyList(),
    val weather_icons: List<String> = emptyList(),
    val wind_degree: Int? = 0,
    val wind_dir: String? = null,
    val wind_speed: Int? = 0
)