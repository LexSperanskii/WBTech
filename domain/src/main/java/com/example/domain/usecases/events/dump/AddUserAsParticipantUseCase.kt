package com.example.domain.usecases.events.dump

import com.example.domain.models.RegisteredPerson
import com.example.domain.repositories.networkRepository.IEventRepository


interface AddUserAsParticipantUseCase {
    suspend fun execute(eventId: Int, participant: RegisteredPerson)
}

internal class AddUserAsParticipantUseCaseImpl(private val eventRepository: IEventRepository) :
    AddUserAsParticipantUseCase {

    override suspend fun execute(eventId: Int, participant: RegisteredPerson) {
        eventRepository.addUserAsParticipant(eventId, participant)
    }

}