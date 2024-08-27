package com.example.data.repositoriesImpl

import com.example.domain.models.Uiv1Event
import com.example.domain.models.Uiv1EventDetail
import com.example.domain.models.Uiv1MockData
import com.example.domain.models.Uiv1RegisteredPerson
import com.example.domain.repositories.Uiv1IEventRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class EventRepositoryImplUiv1(private val mock: Uiv1MockData) : Uiv1IEventRepository {

    override fun getListOfEvents(): Flow<List<Uiv1Event>> {
        return flow {
            emit(mock.getListOfEvents())
        }.flowOn(Dispatchers.IO)
    }

    override fun getEventDetail(eventId: Int): Flow<Uiv1EventDetail> {
        return flow {
            emit(mock.getEventDetail(eventId))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun addUserAsParticipant(eventId: Int, participant: Uiv1RegisteredPerson) {
        mock.addUserAsParticipant(participant)
    }

    override suspend fun removeUserAsParticipant(eventId: Int, participant: Uiv1RegisteredPerson) {
        mock.removeUserAsParticipant(participant)
    }

}