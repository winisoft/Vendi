package steve.sample.vendi.machine.stock

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import steve.sample.vendi.machine.stock.Product
import javax.inject.Inject
import kotlin.random.Random

@ExperimentalStdlibApi
class ProductStock
@Inject
constructor(

): Stock {

    override val itemList: MutableList<Product> = randomStock
    private val _items = MutableStateFlow(randomStock.toList())
    val items: StateFlow<List<Product>> get() = _items

    val colaCount: Int = items.value.count { it is Product.Cola }
    val chipsCount: Int = items.value.count { it is Product.Chips }
    val candyCount: Int = items.value.count { it is Product.Candy }

    fun hasProduct(product: Product): Boolean = when (product) {
        is Product.Cola -> colaCount < 1
        is Product.Chips -> chipsCount < 1
        is Product.Candy -> candyCount < 1
    }
}

@ExperimentalStdlibApi
val randomStock = buildList{
    with(listOf(Product.Cola, Product.Candy, Product.Chips)) {
        forEach { product -> repeat(Random.nextInt(1, 30)) { add(product) } }
    }
}.toMutableList()