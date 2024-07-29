package com.example.domain.usecases.events

import com.example.domain.models.RegisteredPerson
import com.example.domain.repositories.IEventRepository


interface RemoveUserAsParticipantUseCase {
    suspend fun execute(eventId: Int, participant: RegisteredPerson)
}

internal class RemoveUserAsParticipantUseCaseImpl(private val eventRepository: IEventRepository) :
    RemoveUserAsParticipantUseCase {

    override suspend fun execute(eventId: Int, participant: RegisteredPerson) {
        eventRepository.removeUserAsParticipant(eventId, participant)
    }

}