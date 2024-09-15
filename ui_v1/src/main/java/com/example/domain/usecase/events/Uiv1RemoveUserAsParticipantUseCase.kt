package com.example.domain.usecase.events

import com.example.domain.models.Uiv1RegisteredPerson
import com.example.domain.repositories.Uiv1IEventRepository


internal interface Uiv1RemoveUserAsParticipantUseCase {
    suspend fun execute(eventId: Int, participant: Uiv1RegisteredPerson)
}

internal class Uiv1RemoveUserAsParticipantUseCaseImpl(private val eventRepository: Uiv1IEventRepository) :
    Uiv1RemoveUserAsParticipantUseCase {

    override suspend fun execute(eventId: Int, participant: Uiv1RegisteredPerson) {
        eventRepository.removeUserAsParticipant(eventId, participant)
    }

}