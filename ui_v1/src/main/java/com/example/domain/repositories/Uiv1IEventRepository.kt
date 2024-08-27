package com.example.domain.repositories

import com.example.domain.models.Uiv1Event
import com.example.domain.models.Uiv1EventDetail
import com.example.domain.models.Uiv1RegisteredPerson
import kotlinx.coroutines.flow.Flow

internal interface Uiv1IEventRepository {

    fun getListOfEvents(): Flow<List<Uiv1Event>>

    fun getEventDetail(eventId: Int): Flow<Uiv1EventDetail>

    suspend fun addUserAsParticipant(eventId: Int, participant: Uiv1RegisteredPerson)

    suspend fun removeUserAsParticipant(eventId: Int, participant: Uiv1RegisteredPerson)

}