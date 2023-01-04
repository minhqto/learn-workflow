package com.minhto.coffeetime.data.api

import com.minhto.coffeetime.data.model.CoffeeDTO
import retrofit2.Call
import retrofit2.http.GET

interface CoffeeApi {

  @GET(".")
  suspend fun getCoffees(): List<CoffeeDTO>
}