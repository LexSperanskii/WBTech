package com.example.domain.usecases.events

import com.example.domain.repositories.IEventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


interface GetAllEventsActiveUseCase {
    fun execute(): Flow<List<Event>>
}

internal class GetAllEventsActiveUseCaseImpl(private val eventRepository: IEventRepository) :
    GetAllEventsActiveUseCase {

    override fun execute(): Flow<List<Event>> {
        return eventRepository.getListOfEvents()
            .map { eventList ->
                eventList.filter { event -> !event.isFinished }
            }
    }

}