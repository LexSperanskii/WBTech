package com.example.domain.usecases.events

import com.example.domain.models.Uiv1RegisteredPerson
import com.example.domain.repositories.Uiv1IEventRepository


internal interface Uiv1AddUserAsParticipantUseCase {
    suspend fun execute(eventId: Int, participant: Uiv1RegisteredPerson)
}

internal class Uiv1AddUserAsParticipantUseCaseImpl(private val eventRepository: Uiv1IEventRepository) :
    Uiv1AddUserAsParticipantUseCase {

    override suspend fun execute(eventId: Int, participant: Uiv1RegisteredPerson) {
        eventRepository.addUserAsParticipant(eventId, participant)
    }

}