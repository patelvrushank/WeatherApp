package com.vrushank.WeatherApp.services.retrofit

import okhttp3.Interceptor

class HeaderIntercepter:Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain.request().newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("User-Agent", "Mozilla/5.0")
            .build()
        return chain.proceed(request)
    }
}