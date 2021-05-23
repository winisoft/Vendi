package steve.sample.vendi.machine.acceptor

import steve.sample.vendi.machine.change.CoinReturn
import steve.sample.vendi.machine.acceptor.bank.BalanceCoinBank
import steve.sample.vendi.machine.acceptor.filters.CoinSeparator
import steve.sample.vendi.machine.acceptor.filters.IdentificationProbe
import steve.sample.vendi.money.MaybeCoinObject
import steve.sample.vendi.money.TheoreticalCoin
import steve.sample.vendi.money.TheoreticalCoin.Quarter
import steve.sample.vendi.money.TheoreticalCoin.Nickel
import steve.sample.vendi.money.TheoreticalCoin.Dime
import javax.inject.Inject

class CoinAcceptor
@Inject
constructor(
    private val identificationProbe: IdentificationProbe,
    private val coinFilters: CoinSeparator,
    private val coinBank: BalanceCoinBank
) {

    /**
     * Attempts the insertion of some object into the [CoinAcceptor] mechanism.
     * Checks whether the object reacts to magnetism like any of the coins we accept, checks whether
     * the shape, size, and weight are a match, then adds it to the coinbank where it should (if it should).
     * Otherwise, it's rejected to the coin return
     *
     * @param maybeCoin the object the user wants to insert
     * @return The coin type identified, if the coin was accepted. If not, null.
     */
    fun insert(maybeCoin: MaybeCoinObject): TheoreticalCoin? {
        if (!maybeCoin.fitsIntoSlot)
            throw Exception("This object doesn't even fit.")

        val materialMatch: TheoreticalCoin? = identificationProbe.gateToUnlock(maybeCoin)
        val weightMatch: TheoreticalCoin? = coinFilters.sort(maybeCoin)

        if (materialMatch == null || weightMatch == null) {
            CoinReturn.add(maybeCoin)
            return null
        }

        return when (materialMatch to weightMatch) {
            Quarter to Quarter -> { coinBank.addQuarter(); Quarter }
            Nickel to Nickel -> { coinBank.addNickel(); Nickel }
            Dime to Dime -> { coinBank.addDime(); Dime }
            else -> { CoinReturn.add(maybeCoin); null }
        }
    }

    /**
     * Determines whether a given item the user attempts to insert into the coin acceptor's slot
     * would fit into it at all. This could just as easily compare against some constant, of course
     */
    private val MaybeCoinObject.fitsIntoSlot: Boolean
        get() = lengthMicrometers <= Quarter.diameterMicrometers * 2
            && widestPointMicrometers <= Quarter.thicknessMicrometers

}