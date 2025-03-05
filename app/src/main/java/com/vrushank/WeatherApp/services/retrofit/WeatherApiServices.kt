package com.vrushank.WeatherApp.services.retrofit

import com.squareup.moshi.Moshi
import com.vrushank.WeatherApp.utils.URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


object WeatherServices {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            //.client(OkHttpClient.Builder().addInterceptor(HeaderIntercepter()).build())
            .addConverterFactory(
              //  MoshiConverterFactory.create(Moshi.Builder().build())
                GsonConverterFactory.create()
            )
            .build()
    }
    val api: WeatherApi by lazy {
        retrofit.create(WeatherApi::class.java)
    }

}