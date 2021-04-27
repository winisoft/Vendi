package steve.sample.vendi.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import steve.sample.vendi.machine.VendingMachine
import steve.sample.vendi.machine.stock.Product
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    val vendingMachine: VendingMachine
): ViewModel() {

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
    }
}