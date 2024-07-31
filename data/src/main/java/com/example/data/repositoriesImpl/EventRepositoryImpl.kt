package com.example.data.repositoriesImpl

import com.example.domain.models.Event
import com.example.domain.models.EventDetail
import com.example.domain.models.MockData
import com.example.domain.models.RegisteredPerson
import com.example.domain.repositories.IEventRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class EventRepositoryImpl(private val mock: MockData) : IEventRepository {

    override fun getListOfEvents(): Flow<List<Event>> {
        return flow{
            emit(mock.getListOfEvents())
        }.flowOn(Dispatchers.IO)
    }

    override fun getEventDetail(eventId: Int): Flow<EventDetail> {
        return flow{
            emit(mock.getEventDetail(eventId))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun addUserAsParticipant(eventId: Int, participant: RegisteredPerson) {
        mock.addUserAsParticipant(participant)
    }

    override suspend fun removeUserAsParticipant(eventId: Int, participant: RegisteredPerson) {
        mock.removeUserAsParticipant(participant)
    }

}