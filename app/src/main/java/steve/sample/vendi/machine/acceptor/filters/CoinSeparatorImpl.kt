package steve.sample.vendi.machine.acceptor.filters
import steve.sample.vendi.money.MaybeCoinObject
import steve.sample.vendi.money.TheoreticalCoin
import steve.sample.vendi.money.TheoreticalCoin.Quarter
import steve.sample.vendi.money.TheoreticalCoin.Dime
import steve.sample.vendi.money.TheoreticalCoin.Nickel
import javax.inject.Inject

/**
 * As in a typical coin acceptor, the inserted object is dropped into a stack of sorting mechanisms,
 * where, one by one, it has the opportunity to fit into the expected weight and size for that
 * individual mechanism, and get sorted into the coin bank.
 */
class CoinSeparatorImpl
@Inject
constructor()
: CoinSeparator {

    override fun sort(maybeCoin: MaybeCoinObject): TheoreticalCoin? {
        for (element in coinFilters) {
            element.findWeightMatch(maybeCoin)?.let { return it } }
        return null
    }

    private val coinFilters: List<CoinWeightFilter> = listOf(
        object: CoinWeightFilter {
            override fun findWeightMatch(candidate: MaybeCoinObject): Quarter? =
                if (candidate.lengthMicrometers == Quarter.diameterMicrometers * 2
                    && candidate.widestPointMicrometers == Quarter.thicknessMicrometers
                    && candidate.weightMilligrams == Quarter.weightMilligrams
                ) Quarter else null
        },
        object: CoinWeightFilter {
            override fun findWeightMatch(candidate: MaybeCoinObject): Nickel? =
                if (candidate.lengthMicrometers == Nickel.diameterMicrometers * 2
                    && candidate.widestPointMicrometers == Nickel.thicknessMicrometers
                    && candidate.weightMilligrams == Nickel.weightMilligrams
                ) Nickel else null
        },
        object: CoinWeightFilter {
            override fun findWeightMatch(candidate: MaybeCoinObject): Dime? =
                if (candidate.lengthMicrometers == Dime.diameterMicrometers * 2
                    && candidate.widestPointMicrometers == Dime.thicknessMicrometers
                    && candidate.weightMilligrams == Dime.weightMilligrams
                ) Dime else null
        }
    )
}