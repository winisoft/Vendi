package steve.sample.vendi.machine.acceptor.bank

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import steve.sample.vendi.machine.change.CoinReturn
import steve.sample.vendi.money.TheoreticalCoin
import steve.sample.vendi.money.TheoreticalCoin.Quarter
import steve.sample.vendi.money.TheoreticalCoin.Dime
import steve.sample.vendi.money.TheoreticalCoin.Nickel
import steve.sample.vendi.money.MaybeCoinObject
import java.lang.IllegalArgumentException
import javax.inject.Inject

class BalanceCoinBankImpl
@Inject
constructor() : BalanceCoinBank {

    private val _balance = MutableStateFlow(0f)
    override val balance: StateFlow<Float> = _balance

    private var countNickels: Int = 0
    private var countDimes: Int = 0
    private var countQuarters: Int = 0

    override fun addQuarter() {
        countQuarters += 1
        _balance.value = _balance.value + Quarter.currencyValue
    }

    override fun addDime() {
        countDimes += 1
        _balance.value += Dime.currencyValue
    }

    override fun addNickel() {
        countNickels += 1
        _balance.value += Nickel.currencyValue
    }

    override fun purchase(price: Float) {
        if (balance.value < price)
            throw IllegalArgumentException("Attempted purchase with insufficient balance")

        var notYetTendered = price
        while(notYetTendered > 0f) {
            when {
                notYetTendered >= Quarter.currencyValue && countQuarters > 0 -> {
                    _balance.value -= Quarter.currencyValue
                    notYetTendered -= Quarter.currencyValue
                    countQuarters -= 1
                }
                notYetTendered < Quarter.currencyValue
                && balance.value >= Dime.currencyValue
                && countDimes > 0 -> {
                    _balance.value -= Dime.currencyValue
                    notYetTendered -= Dime.currencyValue
                    countDimes -= 1
                }
                else -> {
                    _balance.value -= Nickel.currencyValue
                    notYetTendered -= Nickel.currencyValue
                    countNickels -= 1
                }
            }
        }

        refundCurrentBalance()
    }

    override fun refundCurrentBalance() {
        repeat(countNickels) {
            returnObject(Nickel)
            countNickels -= 1
        }
        repeat(countDimes) {
            returnObject(Dime)
            countDimes -= 1
        }
        repeat(countQuarters) {
            returnObject(Quarter)
            countQuarters -= 1
        }
    }

    private fun returnObject(coin: TheoreticalCoin) {
        CoinReturn.add(object: MaybeCoinObject {
            override val weightMilligrams = coin.weightMilligrams
            override val lengthMicrometers = coin.diameterMicrometers * 2
            override val widestPointMicrometers = coin.thicknessMicrometers
            override val materialComposition: MaybeCoinObject.MaterialComposition =
                when (coin) {
                    is Quarter, Dime -> MaybeCoinObject.MaterialComposition.COPPER_92_NICKEL_8
                    is Nickel -> MaybeCoinObject.MaterialComposition.COPPER_75_NICKEL_25
                    else -> throw IllegalArgumentException("How is this not a dime, a quarter, or nickel")
                }
        })
        _balance.value -= coin.currencyValue
    }

}