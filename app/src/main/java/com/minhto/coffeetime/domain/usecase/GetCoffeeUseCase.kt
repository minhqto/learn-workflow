package com.minhto.coffeetime.domain.usecase

import com.minhto.coffeetime.data.api.ApiBuilder

class GetCoffeeUseCase {
  private val api = ApiBuilder.api

  suspend fun getCoffees() = api.getCoffees()
}