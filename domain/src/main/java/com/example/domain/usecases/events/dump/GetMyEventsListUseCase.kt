package com.example.domain.usecases.events.dump

import com.example.domain.repositories.networkRepository.IEventRepository
import kotlinx.coroutines.flow.Flow


interface GetMyEventsListUseCase {
    fun execute(): Flow<List<Event>>
}

internal class GetMyEventsListUseCaseImpl(private val eventRepository: IEventRepository) :
    GetMyEventsListUseCase {

    override fun execute(): Flow<List<Event>>{
        return eventRepository.getListOfEvents()
    }
}