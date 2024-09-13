package com.example.domain.usecases.events

import com.example.domain.repositories.IEventRepository
import kotlinx.coroutines.flow.Flow


interface GetAllEventsUseCase {
    fun execute(): Flow<List<Event>>
}

internal class GetAllEventsUseCaseImpl(private val eventRepository: IEventRepository) :
    GetAllEventsUseCase {

    override fun execute(): Flow<List<Event>>{
        return eventRepository.getListOfEvents()
    }

}