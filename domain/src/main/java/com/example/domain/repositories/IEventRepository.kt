package com.example.domain.repositories

import com.example.domain.models.Event
import com.example.domain.models.EventDetail

interface IEventRepository {
    fun getListOfEvents(): List<Event>
    fun getEventDetail(): EventDetail
}