package steve.sample.vendi.infrastructure

interface Intention<T> {
    suspend fun reduce(previousState: T): T
}