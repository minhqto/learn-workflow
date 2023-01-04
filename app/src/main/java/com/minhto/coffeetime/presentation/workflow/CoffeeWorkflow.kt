package com.minhto.coffeetime.presentation.workflow

import android.util.Log
import com.minhto.coffeetime.domain.worker.CoffeeWorker
import com.minhto.coffeetime.presentation.viewdata.CoffeeScreen
import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.squareup.workflow1.action
import com.squareup.workflow1.runningWorker

class CoffeeWorkflow : StatefulWorkflow<Unit, CoffeeState, Nothing, CoffeeScreen>() {

  override fun snapshotState(state: CoffeeState): Snapshot? = null

  override fun initialState(
    props: Unit,
    snapshot: Snapshot?
  ): CoffeeState = CoffeeState(coffees = emptyList())

  override fun render(
    renderProps: Unit,
    renderState: CoffeeState,
    context: RenderContext
  ): CoffeeScreen {
    val coffeeWorker = CoffeeWorker()
    context.runningWorker(coffeeWorker) { coffeeDTO ->
      action {
        state = state.copy(coffees = coffeeDTO)
      }
    }

    return CoffeeScreen(recipeName = if (renderState.coffees.isNotEmpty()) renderState.coffees[0].title else "")
  }
}