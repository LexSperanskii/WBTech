package com.example.domain.stabRepositories

import com.example.domain.models.Community
import com.example.domain.models.CommunityDetail
import com.example.domain.models.Event
import com.example.domain.repositories.ICommunityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TestCommunityRepository: ICommunityRepository {

    override fun getListOfCommunities(): Flow<List<Community>> {
        return flow {
            emit(
                listOf(
                    Community(0, "AAA", 1, ""),
                    Community(1, "BBB", 200, ""),
                    Community(2, "CCC", 3000, "")
                )
            )
        }.flowOn(Dispatchers.IO)
    }

    override fun getCommunityDetail(communityId: Int): Flow<CommunityDetail> {
        return flow {
            emit(
                CommunityDetail(
                    id = 0,
                    name = "test",
                    description = "hello",
                    events = listOf(
                        Event(0, "event1", "01.01.2007", "Mockow", listOf("ggg", "hhh"), "", true),
                        Event(0, "event2", "02.01.2007", "Spb", listOf("fff", "jjj"), "", false)
                    )
                )
            )
        }.flowOn(Dispatchers.IO)
    }

}