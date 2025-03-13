package com.vrushank.WeatherApp.ui.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vrushank.WeatherApp.services.model.UiState

@Composable
fun MainScreen(list: List<MutableState<UiState>>) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        LazyColumn (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(8.dp)
        ) {
            items(list) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
                    Column {

                        Row(modifier = Modifier.fillMaxHeight(0.2f)) {
                            item.value.country?.let {
                                Text(
                                    text = "Country Name = $it",
                                    fontSize = 16.sp
                                )
                            }
                        }
                        Row(modifier = Modifier.fillMaxHeight(0.2f)) {
                            item.value.localtime?.let {
                                Text(
                                    text = "Local Time = $it",
                                    fontSize = 16.sp
                                )
                            }
                        }


                        Row(modifier = Modifier.fillMaxHeight(0.2f)) {
                            item.value.feelslike?.let {
                                Text(
                                    text = "Feels Like = $it",
                                    fontSize = 16.sp
                                )
                            }
                        }
                        Row(modifier = Modifier.fillMaxHeight(0.2f)) {
                            item.value.humidity?.let {
                                Text(
                                    text = "Humidity = $it",
                                    fontSize = 16.sp
                                )
                            }
                        }


                    }

                }

            }
        }
    }

}