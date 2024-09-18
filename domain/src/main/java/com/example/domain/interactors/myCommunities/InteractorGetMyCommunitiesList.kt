package com.example.domain.interactors.myCommunities


//interface IInteractorGetMyCommunitiesList {
//    fun invoke(): Flow<List<CommunityModelDomain>>
//}
//
//internal class InteractorGetMyCommunitiesListImpl(
//    private val useCase: EventsUseCase,
//    private val networkRepository: INetworkRepository,
//) : IInteractorGetMyCommunitiesList {
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    private val myCommunities = useCase.observeMyCommunitiesList().flatMapLatest {
//        networkRepository.getMyCommunitiesList()
//    }
//
//    override fun invoke(): Flow<List<CommunityModelDomain>> = myCommunities
//}