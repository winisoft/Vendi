package steve.sample.vendi.machine.acceptor

import steve.sample.vendi.machine.change.CoinReturn
import steve.sample.vendi.machine.acceptor.bank.BalanceCoinBank
import steve.sample.vendi.machine.acceptor.filters.CoinSeparator
import steve.sample.vendi.machine.acceptor.filters.IdentificationProbe
import steve.sample.vendi.money.MaybeCoinObject
import steve.sample.vendi.money.TheoreticalCoin
import javax.inject.Inject

class CoinAcceptor
@Inject
constructor(
    private val identificationProbe: IdentificationProbe,
    private val coinFilters: CoinSeparator,
    private val coinBank: BalanceCoinBank
) {

    /**
     * Attempts the insertion of some object into the [CoinAcceptor] mechanism, proceeding
     * to validate that it is currency if it is accepted.
     *
     * @param maybeCoin the object the user wants to insert
     * @return true if the object entered the housing through its slot, false if not
     */
    fun attemptInsert(maybeCoin: MaybeCoinObject) {
        if (maybeCoin.fitsIntoSlot)
            acceptMaybeCoin(maybeCoin)
        else
            throw Exception("This object doesn't even fit.")
    }

    /**
     * Checks whether the object reacts to magnetism like any of the coins we accept, checks whether
     * the shape, size, and weight are a match, then adds it to the coinbank where it should (if it should).
     * Otherwise, it's rejected to the coin return
     */
    private fun acceptMaybeCoin(maybeCoin: MaybeCoinObject) {

        val materialMatch: TheoreticalCoin? = identificationProbe.gateToUnlock(maybeCoin)
        val weightMatch: TheoreticalCoin? = coinFilters.sort(maybeCoin)

        if (materialMatch == null || weightMatch == null || materialMatch != weightMatch) {
            CoinReturn.add(maybeCoin)
            return
        }

        when (materialMatch) {
            TheoreticalCoin.Quarter -> coinBank.addQuarter()
            TheoreticalCoin.Dime -> coinBank.addDime()
            TheoreticalCoin.Nickel -> coinBank.addNickel()
            else -> CoinReturn.add(maybeCoin)
        }
    }

    /**
     * Determines whether a given item the user attempts to insert into the coin acceptor's slot
     * would fit into it at all. This could just as easily compare against some constant, of course
     */
    private val MaybeCoinObject.fitsIntoSlot: Boolean
        get() = lengthMicrometers <= TheoreticalCoin.Quarter.diameterMicrometers * 2
            && widestPointMicrometers <= TheoreticalCoin.Quarter.thicknessMicrometers

}