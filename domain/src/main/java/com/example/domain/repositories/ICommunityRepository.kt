package com.example.domain.repositories

import kotlinx.coroutines.flow.Flow

interface ICommunityRepository {

    fun getListOfCommunities(): Flow<List<Community>>

    fun getCommunityDetail(communityId: Int): Flow<CommunityDetail>

}