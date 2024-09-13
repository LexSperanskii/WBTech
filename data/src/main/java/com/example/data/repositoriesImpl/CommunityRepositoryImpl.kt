package com.example.data.repositoriesImpl

import com.example.domain.repositories.ICommunityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class CommunityRepositoryImpl(private val mock: MockData) : ICommunityRepository {

    override fun getListOfCommunities(): Flow<List<Community>> {
        return flow{
            emit(mock.getListOfCommunities())
        }.flowOn(Dispatchers.IO)
    }

    override fun getCommunityDetail(communityId: Int): Flow<CommunityDetail> {
        return flow{
            emit(mock.getCommunity(communityId))
        }.flowOn(Dispatchers.IO)
    }
}