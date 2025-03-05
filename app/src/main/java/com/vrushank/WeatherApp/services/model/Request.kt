package com.vrushank.WeatherApp.services.model

data class Request(
    val language: String? = null,
    val query: String? = null,
    val type: String? = null,
    val unit: String? = null
)