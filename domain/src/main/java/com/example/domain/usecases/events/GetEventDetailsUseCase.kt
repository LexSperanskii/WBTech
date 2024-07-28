package com.example.domain.usecases.events

import com.example.domain.models.EventDetail
import com.example.domain.repositories.IEventRepository
import kotlinx.coroutines.flow.Flow

interface GetEventDetailsUseCase {
    fun execute(eventId: Int): Flow<EventDetail>
}

internal class GetEventDetailsInteractor(private val eventRepository: IEventRepository) :
    GetEventDetailsUseCase {

    override fun execute(eventId: Int): Flow<EventDetail>{
        return eventRepository.getEventDetail(eventId)
    }
}