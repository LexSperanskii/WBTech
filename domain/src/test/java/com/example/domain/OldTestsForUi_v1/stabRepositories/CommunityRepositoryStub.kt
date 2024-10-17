package com.example.domain.OldTestsForUi_v1.stabRepositories

//import com.example.domain.repositories.networkRepository.ICommunityRepository
//import com.example.domain.stabRepositories.StubData.communitiesList
//import com.example.domain.stabRepositories.StubData.communityDetail
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.flowOn
//
//class CommunityRepositoryStub: ICommunityRepository {
//
//    override fun getListOfCommunities(): Flow<List<Community>> {
//        return flow {
//            emit(
//                communitiesList
//            )
//        }.flowOn(Dispatchers.IO)
//    }
//
//    override fun getCommunityDetail(communityId: Int): Flow<CommunityDetail> {
//        return flow {
//            emit(
//                communityDetail
//            )
//        }.flowOn(Dispatchers.IO)
//    }
//
//}