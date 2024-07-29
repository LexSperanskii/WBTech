package com.example.domain.usecases.events

import com.example.domain.models.RegisteredPerson
import com.example.domain.repositories.IEventRepository


interface AddUserAsParticipantUseCase {
    suspend fun execute(eventId: Int, participant: RegisteredPerson)
}

internal class AddUserAsParticipantUseCaseImpl(private val eventRepository: IEventRepository) :
    AddUserAsParticipantUseCase {

    override suspend fun execute(eventId: Int, participant: RegisteredPerson) {
        eventRepository.addUserAsParticipant(eventId, participant)
    }

}