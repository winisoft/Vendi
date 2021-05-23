package steve.sample.vendi.infrastructure

interface IntentFactory<E> {

    fun process(viewEvent: E)
}