package com.minhto.coffeetime.presentation.workflow

import com.minhto.coffeetime.databinding.CoffeeViewBinding
import com.minhto.coffeetime.presentation.viewdata.CoffeeScreen
import com.squareup.workflow1.ui.LayoutRunner
import com.squareup.workflow1.ui.LayoutRunner.Companion.bind
import com.squareup.workflow1.ui.ViewEnvironment
import com.squareup.workflow1.ui.ViewFactory
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi

// in this context, the layout runner presents the view data that has been given to the view model/screen
@OptIn(WorkflowUiExperimentalApi::class)
class CoffeeLayoutRunner(
  private val binding: CoffeeViewBinding
) : LayoutRunner<CoffeeScreen> {

  //this method is called whenever the workflow emits a new screen
  override fun showRendering(
    rendering: CoffeeScreen,
    viewEnvironment: ViewEnvironment
  ) {
    binding.coffeeRecipeName.text = rendering.recipeName
  }

  companion object : ViewFactory<CoffeeScreen> by bind(
    CoffeeViewBinding::inflate, ::CoffeeLayoutRunner
  )
}