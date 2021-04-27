package steve.sample.vendi.machine

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import steve.sample.vendi.machine.acceptor.CoinAcceptor
import steve.sample.vendi.machine.acceptor.bank.BalanceCoinBank
import steve.sample.vendi.machine.stock.ProductStock

@Module
@ExperimentalStdlibApi
@InstallIn(ViewModelComponent::class)
object MachineModule {


    @Provides
    fun provideVendingMachine(
        coinAcceptor: CoinAcceptor,
        coinBank: BalanceCoinBank,
        productStock: ProductStock
    ): VendingMachine =
        VendingMachine(coinAcceptor, coinBank, productStock)
}