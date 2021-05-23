package steve.sample.vendi.infrastructure

import dispatch.android.viewmodel.DispatchViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import steve.sample.vendi.main.MainContract


abstract class FlowModelProvider<S>(
    startingState: S
) : DispatchViewModel(), StateContributor<S> {

    private val _stateFlow = MutableStateFlow(startingState)

    override val intentionFlow: Flow<Intention<S>> = flowOf()

    override val stateFlow: StateFlow<S> get() = _stateFlow

    init {
        viewModelScope.launch {
            intentionFlow
                .onEach { onIntention(it) }
                .collect()
        }
    }
}