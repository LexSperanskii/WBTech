package com.example.domain.usecases.events

import com.example.domain.models.Event
import com.example.domain.repositories.IEventRepository


interface GetAllEventsActiveUseCase {
    fun execute(): List<Event>
}

internal class GetAllEventsActiveInteractor(private val eventRepository: IEventRepository) :
    GetAllEventsActiveUseCase {

    override fun execute(): List<Event>{
        return eventRepository.getListOfEvents().filter { !it.isFinished }
    }
}