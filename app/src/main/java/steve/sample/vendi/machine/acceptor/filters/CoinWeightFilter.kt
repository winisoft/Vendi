package steve.sample.vendi.machine.acceptor.filters

import steve.sample.vendi.money.MaybeCoinObject
import steve.sample.vendi.money.TheoreticalCoin

interface CoinWeightFilter {

    /**
     * Simply to make the demonstration robust, this simulates a step in coin validation that ensures
     * the object weighs the correct amount for the coin with the measured dimensions
     */
    fun findWeightMatch(candidate: MaybeCoinObject): TheoreticalCoin?
}