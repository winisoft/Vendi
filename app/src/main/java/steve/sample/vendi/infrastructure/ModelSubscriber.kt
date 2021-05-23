package steve.sample.vendi.infrastructure

import kotlinx.coroutines.flow.StateFlow

/**
 * Represents the contract between a view, and the model it must collect from to received updates
 * regarding its own state, in order to render it.
 */
interface ModelSubscriber<S> {
    suspend fun StateFlow<S>.subscribeToModel()
}