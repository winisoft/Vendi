package steve.sample.vendi.infrastructure

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import steve.sample.vendi.error.ErrorView

interface StateContributor<S> {

    val scope: CoroutineScope

    val intentionFlow: Flow<Intention<S>>

    val stateFlow: StateFlow<S>

    /**
     * Model will receive intents to be processed via this function.
     *
     * ModelState is immutable. Processed intents will work much like `copy()`
     * and create a new (modified) modelState from an old one.
     */
    suspend fun onIntention(intention: Intention<S>)

}