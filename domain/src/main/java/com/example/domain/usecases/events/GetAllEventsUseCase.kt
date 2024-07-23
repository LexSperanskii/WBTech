package com.example.domain.usecases.events

import com.example.domain.models.Event
import com.example.domain.repositories.IEventRepository


interface GetAllEventsUseCase {
    fun execute(): List<Event>
}

internal class GetAllEventsInteractor(private val eventRepository: IEventRepository) :
    GetAllEventsUseCase {

    override fun execute(): List<Event>{
        return eventRepository.getListOfEvents()
    }
}