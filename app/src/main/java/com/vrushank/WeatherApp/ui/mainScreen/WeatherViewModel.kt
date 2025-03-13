package com.vrushank.WeatherApp.ui.mainScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vrushank.WeatherApp.services.model.Response
import com.vrushank.WeatherApp.utils.Resource
import com.vrushank.WeatherApp.services.model.UiState
import com.vrushank.WeatherApp.services.repo.WeatherRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.jetbrains.annotations.Async


class WeatherViewModel(val repository: WeatherRepository) : ViewModel() {
    val _uiState1 = mutableStateOf(UiState())
    val uiState1: MutableState<UiState> get() = _uiState1
    val _uiState2 = mutableStateOf(UiState())
    val uiState2: MutableState<UiState> get() = _uiState2

    init {
        fetchData()

    }

    fun fetchData() {
        viewModelScope.launch {


            val response1 = async {
                repository.getCurrentWeather("New Delhi")
            }
            val response2 = async {
                repository.getCurrentWeather("Toronto")
            }

            try {
                val result1 = response1.await()
                apiCall(result1,_uiState1)
                val result2 = response2.await()
                apiCall(result2,_uiState2)
            } catch (e: Exception) {
                println("Error : ${e.message}")
            }


        }
    }

        fun apiCall(result: Resource<Response>, ui:MutableState<UiState>) {


            when (result) {
                is Resource.Success -> {
                    var uiVaiable: UiState? = null
                      result.data?.apply {
                        uiVaiable = UiState(
                            feelslike = current.feelslike,
                            humidity = current.humidity,
                            precip = current.precip,
                            pressure = current.pressure,
                            temperature = current.temperature,
                            uv_index = current.uv_index,
                            visibility = current.visibility,
                            weather_code = current.weather_code,
                            wind_degree = current.wind_degree,
                            wind_dir = current.wind_dir,
                            wind_speed = current.wind_speed,
                            country = location.country,
                            localtime = location.localtime
                        )
                    }
                    ui.value = uiVaiable!!
                }

                is Resource.Error -> println("Somthing went wrong")
                is Resource.Loading -> {
                }
            }
        }


}
