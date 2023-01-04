package com.minhto.coffeetime.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiBuilder {

  val api: CoffeeApi by lazy {
    Retrofit
      .Builder()
      .baseUrl("https://api.sampleapis.com/coffee/hot/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create()
  }
}