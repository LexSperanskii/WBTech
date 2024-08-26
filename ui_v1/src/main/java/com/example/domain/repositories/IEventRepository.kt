package com.example.domain.repositories

import com.example.domain.models.Event
import com.example.domain.models.EventDetail
import com.example.domain.models.RegisteredPerson
import kotlinx.coroutines.flow.Flow

interface IEventRepository {

    fun getListOfEvents(): Flow<List<Event>>

    fun getEventDetail(eventId: Int): Flow<EventDetail>

    suspend fun addUserAsParticipant(eventId: Int, participant: RegisteredPerson)

    suspend fun removeUserAsParticipant(eventId: Int, participant: RegisteredPerson)

}