package com.vrushank.WeatherApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.vrushank.WeatherApp.services.repo.WeatherRepository
import com.vrushank.WeatherApp.ui.mainScreen.MainScreen
import com.vrushank.WeatherApp.ui.mainScreen.WeatherViewModel
import com.vrushank.WeatherApp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val vm:WeatherViewModel by viewModels {
                object : ViewModelProvider.Factory{
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                       if (modelClass.isAssignableFrom(WeatherViewModel::class.java)){
                           val repository = WeatherRepository()
                           @Suppress("UNCHECKED_CAST")
                           return WeatherViewModel(repository) as T

                       }
                        throw IllegalArgumentException("Unknown ViewModel class")
                    }
                }
            }
            val uiState = vm.uiState
            WeatherAppTheme {
                MainScreen(
                uiState.value
                )
            }
        }
    }
}

