package steve.sample.vendi.machine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import steve.sample.vendi.user.User
import steve.sample.vendi.machine.acceptor.CoinAcceptor
import steve.sample.vendi.machine.acceptor.bank.BalanceCoinBank
import steve.sample.vendi.machine.stock.Product
import steve.sample.vendi.machine.stock.ProductStock
import steve.sample.vendi.money.MaybeCoinObject
import javax.inject.Inject

class VendingMachine
@ExperimentalStdlibApi
@Inject
constructor(
    val coinAcceptor: CoinAcceptor,
    val coinBank: BalanceCoinBank,
    val productStock: ProductStock
) {

    val user: User = User()
    lateinit var scope: CoroutineScope

    val _display = MutableStateFlow<String>("INSERT COIN")
    val display: StateFlow<String> get() = _display

    val purchasedItemsBin: MutableList<Product> = mutableListOf()

    fun insert(maybeCoinObject: MaybeCoinObject) {
        coinAcceptor.attemptInsert(maybeCoinObject)
    }

    fun initialize(scope: CoroutineScope) {
        this.scope = scope
        this.scope.launch {
            coinBank.balance.collect {
                _display.value = "INSERT COIN | $it"
            }
        }
    }

    @ExperimentalStdlibApi
    private fun attemptPurchase(product: Product) {

        if (productStock.hasProduct(product).not()) {
            showMessageTemporary("SOLD OUT")
            return
        }

        if (coinBank.balance.value < product.price) {
            showMessageTemporary("PRICE ${product.price}")
            return
        }

        coinBank.purchase(product.price)
        productStock.itemList.remove(product)
        purchasedItemsBin.add(product)
        coinBank.refundCurrentBalance()
        showMessageTemporary("THANK YOU")
    }

    private fun showMessageTemporary(message: String) {
        scope.launch {
            _display.value = message
            delay(3000)
            _display.value = "INSERT COIN"
        }
    }

    @ExperimentalStdlibApi
    fun onPurchaseColaPressed() {
        attemptPurchase(Product.Cola)
    }

    @ExperimentalStdlibApi
    fun onPurchaseChipsPressed() {
        attemptPurchase(Product.Chips)
    }

    @ExperimentalStdlibApi
    fun onPurchaseCandyPressed() {
        attemptPurchase(Product.Candy)
    }

    fun refund() {
        coinBank.refundCurrentBalance()
    }
}