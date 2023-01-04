package com.minhto.coffeetime.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minhto.coffeetime.presentation.viewdata.CoffeeScreen
import com.minhto.coffeetime.presentation.workflow.CoffeeLayoutRunner
import com.minhto.coffeetime.presentation.workflow.CoffeeWorkflow
import com.squareup.workflow1.ui.renderWorkflowIn
import com.squareup.workflow1.ui.ViewRegistry
import com.squareup.workflow1.ui.WorkflowLayout
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import kotlinx.coroutines.flow.StateFlow

@OptIn(WorkflowUiExperimentalApi::class)
class MainActivity : ComponentActivity() {

  private val viewRegistry = ViewRegistry(CoffeeLayoutRunner)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val viewModel: CoffeeViewModel by viewModels()
    val view = WorkflowLayout(this)
    view.start(lifecycle, viewModel.renderings, viewRegistry)
    setContentView(view)
  }
}

@OptIn(WorkflowUiExperimentalApi::class)
class CoffeeViewModel(savedState: SavedStateHandle) : ViewModel() {
  val renderings: StateFlow<CoffeeScreen> = renderWorkflowIn(
      workflow = CoffeeWorkflow(),
      scope = this.viewModelScope,
      savedStateHandle = savedState
    )
}
