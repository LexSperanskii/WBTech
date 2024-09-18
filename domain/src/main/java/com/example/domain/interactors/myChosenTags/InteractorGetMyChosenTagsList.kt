package com.example.domain.interactors.myChosenTags


//interface IInteractorGetMyChosenTagsList {
//    fun invoke(): Flow<List<String>>
//}
//
//internal class InteractorGetMyChosenTagsListImpl(
//    private val useCase: EventsUseCase,
//    private val networkRepository: INetworkRepository,
//) : IInteractorGetMyChosenTagsList {
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    private val myChosenTagsList = useCase.observeMyChosenTagsList().flatMapLatest {
//        networkRepository.getMyChosenTagsList()
//    }
//
//    override fun invoke(): Flow<List<String>> = myChosenTagsList
//}