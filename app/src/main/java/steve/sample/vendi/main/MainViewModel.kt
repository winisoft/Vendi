package steve.sample.vendi.main

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import steve.sample.vendi.infrastructure.FlowModelProvider
import steve.sample.vendi.machine.VendingMachine
import steve.sample.vendi.machine.stock.Product
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    val vendingMachine: VendingMachine
): FlowModelProvider<MainContract.MainState<MainContract.MainView>>(MainContract.MainState.Initial as MainContract.MainState<*>) {

    @ExperimentalStdlibApi
    fun onProductClicked(product: Product): () -> Unit = {
        when(product) {
            is Product.Cola -> vendingMachine.onPurchaseCandyPressed()
            is Product.Chips -> vendingMachine.onPurchaseChipsPressed()
            is Product.Candy -> vendingMachine.onPurchaseCandyPressed()
        }
    }


    init {
        vendingMachine.initialize(viewModelScope)
        viewModelScope.launch {
            vendingMachine.coinBank.balance
                .onEach {
                    val a = it
                }.collect()
        }
    }
}