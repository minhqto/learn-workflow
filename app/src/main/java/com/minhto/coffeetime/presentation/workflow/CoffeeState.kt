package com.minhto.coffeetime.presentation.workflow

import com.minhto.coffeetime.data.model.CoffeeDTO

data class CoffeeState(
  val coffees: List<CoffeeDTO> = emptyList()
)