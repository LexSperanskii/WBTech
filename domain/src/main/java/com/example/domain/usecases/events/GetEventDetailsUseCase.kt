package com.example.domain.usecases.events

import com.example.domain.models.EventDetail
import com.example.domain.repositories.IEventRepository

interface GetEventDetailsUseCase {
    fun execute(): EventDetail
}

internal class GetEventDetailsInteractor(private val eventRepository: IEventRepository) :
    GetEventDetailsUseCase {

    override fun execute(): EventDetail{
        return eventRepository.getEventDetail()
    }
}