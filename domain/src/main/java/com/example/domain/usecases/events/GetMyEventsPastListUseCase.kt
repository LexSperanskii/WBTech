package com.example.domain.usecases.events

import com.example.domain.models.Event
import com.example.domain.repositories.IEventRepository


interface GetMyEventsPastListUseCase {
    fun execute(): List<Event>
}

internal class GetMyEventsPastListInteractor(private val eventRepository: IEventRepository) :
    GetMyEventsPastListUseCase {

    override fun execute(): List<Event>{
        return eventRepository.getListOfEvents().filter { it.isFinished }
        }
}