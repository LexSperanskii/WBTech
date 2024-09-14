package com.example.domain.usecases.events

import com.example.domain.models.EventModelDomain
import com.example.domain.repositories.networkRepository.IEventRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

internal class EventsUseCase(
    private val eventRepository: IEventRepository,
) {

    private val eventsFlow = MutableSharedFlow<List<EventModelDomain>>(replay = 1)

    init {
        CoroutineScope(Job() + Dispatchers.IO).launch {
            eventRepository.eventsList().collect {
                eventsFlow.emit(it)
            }
        }
    }

    fun observeEventsList(): Flow<List<EventModelDomain>> = eventsFlow
    fun refreshEventsList() {
        CoroutineScope(Job() + Dispatchers.IO).launch {
            val events = eventRepository.eventsList().first() // Получаем список событий
            eventsFlow.emit(events) // Эмитим список в eventsFlow}
        }
    }
}