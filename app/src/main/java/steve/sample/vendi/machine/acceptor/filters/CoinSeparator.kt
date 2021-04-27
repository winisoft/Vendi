package steve.sample.vendi.machine.acceptor.filters

import steve.sample.vendi.money.MaybeCoinObject
import steve.sample.vendi.money.TheoreticalCoin

interface CoinSeparator {

    /**
     * Returns the type of coin (that is accepted) that would match the physical properties of the
     * object that was inserted, or null if no accepted type of coin fits
     */
    fun sort(maybeCoin: MaybeCoinObject): TheoreticalCoin?
}