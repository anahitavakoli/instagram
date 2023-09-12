package com.anahitavakoli.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://mobilemasters.ir/apps/instagram/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}