package steve.sample.vendi.infrastructure

import kotlinx.coroutines.flow.StateFlow

interface ModelStore<S> {

    /**
     * The model receives intents to be processed via this function.
     *
     * Because the model's state is immutable, the data class intents must call copy() and create a  ModelState is immutable. Processed intents will work much like `copy()`
     * new, but likely modified, modelState from an old one.
     */
    fun process(intention: Intention<S>)

    /**
     * A StateFlow emitting changes applied to the model's state for the views to subscribe to, that
     * will provide them all the properties they need to populate widgets in the view
     */
    fun modelState(): StateFlow<S>
}