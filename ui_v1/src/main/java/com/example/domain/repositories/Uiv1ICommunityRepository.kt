package com.example.domain.repositories

import com.example.domain.models.Uiv1Community
import com.example.domain.models.Uiv1CommunityDetail
import kotlinx.coroutines.flow.Flow

internal interface Uiv1ICommunityRepository {

    fun getListOfCommunities(): Flow<List<Uiv1Community>>

    fun getCommunityDetail(communityId: Int): Flow<Uiv1CommunityDetail>

}