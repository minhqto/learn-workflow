package com.minhto.coffeetime.domain.worker

import com.minhto.coffeetime.data.model.CoffeeDTO
import com.minhto.coffeetime.domain.usecase.GetCoffeeUseCase
import com.squareup.workflow1.Worker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CoffeeWorker : Worker<List<CoffeeDTO>> {

  private val getCoffeeUseCase = GetCoffeeUseCase()

  override fun run(): Flow<List<CoffeeDTO>> = flow { emit (getCoffeeUseCase.getCoffees()) }
}