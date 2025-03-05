package com.vrushank.WeatherApp.services.model

data class Location(
    val country: String? = null,
    val lat: String? = null,
    val localtime: String? = null,
    val localtime_epoch: Int? = 0,
    val lon: String? = null,
    val name: String?=null,
    val region: String?=null,
    val timezone_id: String?=null,
    val utc_offset: String?=null
)