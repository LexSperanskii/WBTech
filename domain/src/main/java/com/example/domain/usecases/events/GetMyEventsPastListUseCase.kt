package com.example.domain.usecases.events

import com.example.domain.models.Event
import com.example.domain.repositories.IEventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


interface GetMyEventsPastListUseCase {
    fun execute(): Flow<List<Event>>
}

internal class GetMyEventsPastListInteractor(private val eventRepository: IEventRepository) :
    GetMyEventsPastListUseCase {

    override fun execute(): Flow<List<Event>>{
        return eventRepository.getListOfEvents()
            .map { eventList ->
                eventList.filter { event -> event.isFinished }
            }
        }

}