package com.example.domain.repositories

import com.example.domain.models.Community
import com.example.domain.models.CommunityDetail
import kotlinx.coroutines.flow.Flow

interface ICommunityRepository {

    fun getListOfCommunities(): Flow<List<Community>>

    fun getCommunityDetail(communityId: Int): Flow<CommunityDetail>

}