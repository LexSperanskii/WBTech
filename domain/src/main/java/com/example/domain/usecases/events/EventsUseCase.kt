package com.example.domain.usecases.events

import com.example.domain.models.EventModelDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

internal class EventsUseCase {

    private val eventsFlow = MutableSharedFlow<List<EventModelDomain>>()


    fun observeEventsList(): Flow<List<EventModelDomain>> = eventsFlow

}