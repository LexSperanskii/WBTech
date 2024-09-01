package com.example.domain.usecases.events

import com.example.domain.models.Uiv1EventDetail
import com.example.domain.repositories.Uiv1IEventRepository
import kotlinx.coroutines.flow.Flow

internal interface Uiv1GetEventDetailsUseCase {
    fun execute(eventId: Int): Flow<Uiv1EventDetail>
}

internal class Uiv1GetEventDetailsUseCaseImpl(private val eventRepository: Uiv1IEventRepository) :
    Uiv1GetEventDetailsUseCase {

    override fun execute(eventId: Int): Flow<Uiv1EventDetail> {
        return eventRepository.getEventDetail(eventId)
    }
}