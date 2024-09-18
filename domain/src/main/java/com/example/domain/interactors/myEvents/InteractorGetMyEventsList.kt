package com.example.domain.interactors.myEvents


//interface IInteractorGetMyEventsList {
//    fun invoke(): Flow<List<EventModelDomain>>
//}
//
//internal class InteractorGetMyEventsListImpl(
//    private val useCase: EventsUseCase,
//    private val networkRepository: INetworkRepository,
//) : IInteractorGetMyEventsList {
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    private val myEvents = useCase.observeMyEventsList().flatMapLatest {
//        networkRepository.getMyEventsList()
//    }
//
//    override fun invoke(): Flow<List<EventModelDomain>> = myEvents
//}