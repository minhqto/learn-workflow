package com.minhto.coffeetime.data.model

import com.google.gson.annotations.SerializedName

class CoffeeDTO(
  @SerializedName("title") val title: String,
  @SerializedName("description") val description: String,
)