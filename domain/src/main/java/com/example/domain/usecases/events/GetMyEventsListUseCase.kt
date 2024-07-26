package com.example.domain.usecases.events

import com.example.domain.models.Event
import com.example.domain.repositories.IEventRepository
import kotlinx.coroutines.flow.Flow


interface GetMyEventsListUseCase {
    fun execute(): Flow<List<Event>>
}

internal class GetMyEventsListInteractor(private val eventRepository: IEventRepository) :
    GetMyEventsListUseCase {

    override fun execute(): Flow<List<Event>>{
        return eventRepository.getListOfEvents()
    }
}