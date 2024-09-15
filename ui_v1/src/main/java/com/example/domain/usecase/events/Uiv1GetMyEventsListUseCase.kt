package com.example.domain.usecase.events

import com.example.domain.models.Uiv1Event
import com.example.domain.repositories.Uiv1IEventRepository
import kotlinx.coroutines.flow.Flow


internal interface Uiv1GetMyEventsListUseCase {
    fun execute(): Flow<List<Uiv1Event>>
}

internal class Uiv1GetMyEventsListUseCaseImpl(private val eventRepository: Uiv1IEventRepository) :
    Uiv1GetMyEventsListUseCase {

    override fun execute(): Flow<List<Uiv1Event>> {
        return eventRepository.getListOfEvents()
    }
}