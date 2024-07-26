package com.example.domain.usecases.events

import com.example.domain.models.Event
import com.example.domain.repositories.IEventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


interface GetAllEventsUseCase {
    fun execute(): Flow<List<Event>>
}

internal class GetAllEventsInteractor(private val eventRepository: IEventRepository) :
    GetAllEventsUseCase {

    override fun execute(): Flow<List<Event>>{
        return eventRepository.getListOfEvents()
    }

}