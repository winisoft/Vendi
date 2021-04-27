package steve.sample.vendi.machine.acceptor

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import steve.sample.vendi.machine.change.CoinReturn
import steve.sample.vendi.machine.acceptor.bank.BalanceCoinBank
import steve.sample.vendi.machine.acceptor.bank.BalanceCoinBankImpl
import steve.sample.vendi.machine.acceptor.filters.CoinSeparator
import steve.sample.vendi.machine.acceptor.filters.CoinSeparatorImpl
import steve.sample.vendi.machine.acceptor.filters.IdentificationProbe

@Module
@InstallIn(ViewModelComponent::class)
object CoinAcceptorModule {

    @Provides
    fun provideCoinSeparator(): CoinSeparator = CoinSeparatorImpl()

    @Provides
    fun provideBalanceCoinBank(): BalanceCoinBank = BalanceCoinBankImpl()

    @Provides
    fun provideCoinAcceptor(
        identificationProbe: IdentificationProbe,
        coinSeparator: CoinSeparator,
        coinBank: BalanceCoinBank
    ): CoinAcceptor =
        CoinAcceptor(identificationProbe, coinSeparator, coinBank)
}