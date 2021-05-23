package steve.sample.vendi.main

import androidx.lifecycle.Transformations.map
import steve.sample.vendi.error.ErrorView
import steve.sample.vendi.machine.stock.Product

object MainContract {

    data class MainView(
        val balance: String = "0.00",
        val outOfService: Boolean = false,
        val productAvailability: Map<Product, Boolean> = mapOf()
    )

    sealed class MainEvent {
        object Initial: MainEvent()
        object InsertQuarter: MainEvent()
        object InsertDime: MainEvent()
        object InsertNickel: MainEvent()
        object InsertPenny: MainEvent()
        object InsertButton: MainEvent()
        object InsertWoodNickel: MainEvent()
        object CoinReturn: MainEvent()
        object Hit: MainEvent()
    }

    sealed class MainState<T> {
        object Initial: MainState<Nothing>()
        object Loading: MainState<Nothing>()
        data class Error(val errorContent: ErrorView): MainState<Nothing>()
        data class Content(val value: MainView): MainState<MainView>()
    }

}

