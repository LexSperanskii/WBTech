package com.example.domain.usecases.events

import com.example.domain.models.Event
import com.example.domain.repositories.IEventRepository


interface GetMyEventsListUseCase {
    fun execute(): List<Event>
}

internal class GetMyEventsListInteractor(private val eventRepository: IEventRepository) :
    GetMyEventsListUseCase {

    override fun execute(): List<Event>{
        return eventRepository.getListOfEvents()
    }
}