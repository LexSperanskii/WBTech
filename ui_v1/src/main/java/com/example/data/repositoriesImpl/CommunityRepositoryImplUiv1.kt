package com.example.data.repositoriesImpl

import com.example.domain.models.Uiv1Community
import com.example.domain.models.Uiv1CommunityDetail
import com.example.domain.models.Uiv1MockData
import com.example.domain.repositories.Uiv1ICommunityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class CommunityRepositoryImplUiv1(private val mock: Uiv1MockData) :
    Uiv1ICommunityRepository {

    override fun getListOfCommunities(): Flow<List<Uiv1Community>> {
        return flow {
            emit(mock.getListOfCommunities())
        }.flowOn(Dispatchers.IO)
    }

    override fun getCommunityDetail(communityId: Int): Flow<Uiv1CommunityDetail> {
        return flow {
            emit(mock.getCommunity(communityId))
        }.flowOn(Dispatchers.IO)
    }
}