package com.vrushank.WeatherApp.services.retrofit

import com.vrushank.WeatherApp.utils.API_KEY
import com.vrushank.WeatherApp.services.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("current")
    suspend fun getCurrentWeather(
        @Query("access_key")
        access_key:String=API_KEY,
        @Query("query")
        query : String?="New York"
    ): Response
}