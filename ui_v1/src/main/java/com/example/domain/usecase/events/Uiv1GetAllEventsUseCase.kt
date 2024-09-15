package com.example.domain.usecase.events

import com.example.domain.models.Uiv1Event
import com.example.domain.repositories.Uiv1IEventRepository
import kotlinx.coroutines.flow.Flow


internal interface Uiv1GetAllEventsUseCase {
    fun execute(): Flow<List<Uiv1Event>>
}

internal class Uiv1GetAllEventsUseCaseImpl(private val eventRepository: Uiv1IEventRepository) :
    Uiv1GetAllEventsUseCase {

    override fun execute(): Flow<List<Uiv1Event>> {
        return eventRepository.getListOfEvents()
    }

}