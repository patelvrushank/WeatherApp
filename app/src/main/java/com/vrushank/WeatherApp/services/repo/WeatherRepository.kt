package com.vrushank.WeatherApp.services.repo

import com.vrushank.WeatherApp.utils.Resource
import com.vrushank.WeatherApp.services.model.Response
import com.vrushank.WeatherApp.services.retrofit.WeatherServices

class WeatherRepository() {
    val apiService = WeatherServices.api
    suspend fun getCurrentWeather(query:String):Resource<Response>{
        val result = try {
            apiService.getCurrentWeather(query = query)
        }
        catch (e:Exception){
            return Resource.Error("Nework Erro = $e")
        }
        return Resource.Success(result)

    }
}