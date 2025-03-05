package com.vrushank.WeatherApp.ui.mainScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vrushank.WeatherApp.utils.Resource
import com.vrushank.WeatherApp.services.model.UiState
import com.vrushank.WeatherApp.services.repo.WeatherRepository
import kotlinx.coroutines.launch


class WeatherViewModel(val repository: WeatherRepository):ViewModel() {
    val _uiState = mutableStateOf(UiState())
    val uiState : MutableState<UiState> get() = _uiState
init {
    fetchData()
}
    fun fetchData(){
        viewModelScope.launch {
            val result = repository.getCurrentWeather("New Delhi")
            when(result){
                is Resource.Success -> {
                    var uiVaiable:UiState ? = null
                        val successResponse = result.data?.apply {
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
                    _uiState.value = uiVaiable!!
                }
                is  Resource.Error-> println("Somthing went wrong")
                is  Resource.Loading-> {
                }
            }

        }
    }
}
