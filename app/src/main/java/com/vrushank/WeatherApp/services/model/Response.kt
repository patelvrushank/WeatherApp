package com.vrushank.WeatherApp.services.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class  Response(
   @Json(name = "current") val current: Current,
    val location: Location,
    val request: Request
)

