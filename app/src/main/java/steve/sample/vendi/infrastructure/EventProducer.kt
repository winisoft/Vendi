package steve.sample.vendi.infrastructure

import kotlinx.coroutines.flow.Flow

/**
 * Single point of abstraction for all interactions between the user
 * and the view of the application, in the form of a single emitting stream
 */
interface EventProducer<E> {
    fun viewEvents(): Flow<E>
}