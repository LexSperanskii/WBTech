package com.example.data.repositoriesImpl

import com.example.domain.models.Event
import com.example.domain.models.EventDetail
import com.example.domain.models.MockData
import com.example.domain.repositories.IEventRepository

internal class EventRepositoryImpl(private val mock: MockData) : IEventRepository {
    override fun getListOfEvents(): List<Event> {
        return mock.getListOfEvents()
    }

    override fun getEventDetail(): EventDetail {
        return mock.getEventDetail()
    }
}