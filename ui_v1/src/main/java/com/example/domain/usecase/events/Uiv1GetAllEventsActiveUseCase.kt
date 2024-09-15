package com.example.domain.usecase.events

import com.example.domain.models.Uiv1Event
import com.example.domain.repositories.Uiv1IEventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


internal interface Uiv1GetAllEventsActiveUseCase {
    fun execute(): Flow<List<Uiv1Event>>
}

internal class Uiv1GetAllEventsActiveUseCaseImpl(private val eventRepository: Uiv1IEventRepository) :
    Uiv1GetAllEventsActiveUseCase {

    override fun execute(): Flow<List<Uiv1Event>> {
        return eventRepository.getListOfEvents()
            .map { eventList ->
                eventList.filter { event -> !event.isFinished }
            }
    }

}