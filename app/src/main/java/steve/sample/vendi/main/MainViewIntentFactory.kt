package steve.sample.vendi.main

import steve.sample.vendi.infrastructure.Intention

object MainViewIntentFactory : IntentionFactory<MainContract.MainEvent> {

    override fun process(viewEvent: MainContract.MainEvent) {
        UpvoteModelStore.process(toIntent(viewEvent))
    }

//    private fun toIntent(viewEvent: MainViewEvent): Intent<UpvoteModel> {
//        return when (viewEvent) {
//            LoveItClick -> AddHeart()
//            ThumbsUpClick -> AddThumbsUp()
//        }
//    }

//    class AddHeart :Intent<UpvoteModel> {
//        override fun reduce(oldState: UpvoteModel) =
//            oldState.copy(hearts = oldState.hearts + 1)
//    }
//
//    class AddThumbsUp :Intent<UpvoteModel> {
//        override fun reduce(oldState: UpvoteModel) =
//            oldState.copy(thumbs = oldState.thumbs + 1)
//    }

}

/**
 * An example of using a simple DSL.
 *
 * Adding one class per intent can become a bit tedious when
 * your app becomes more complex, DSLs are useful for cutting
 * down boilerplate.
 */
private fun toIntentWithDsl(viewEvent: MainContract.MainEvent): Intention<MainContract.MainView> {
    return object: Intention<MainContract.MainView> {
        override suspend fun reduce(previousState: MainContract.MainView): MainContract.MainView {
            TODO("Not yet implemented")
        }

    }
//    return when (viewEvent) {
//        LoveItClick -> intent {
//            copy(hearts = hearts + 1)
//        }
//        ThumbsUpClick -> intent {
//            copy(thumbs = thumbs + 1)
//        }
//    }
}