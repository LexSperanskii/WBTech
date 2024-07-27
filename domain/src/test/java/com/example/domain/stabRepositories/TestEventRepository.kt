package com.example.domain.stabRepositories

import com.example.domain.models.Community
import com.example.domain.models.Event
import com.example.domain.models.EventAddress
import com.example.domain.models.EventDetail
import com.example.domain.models.RegisteredPerson
import com.example.domain.repositories.IEventRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TestEventRepository : IEventRepository {
    override fun getListOfEvents(): Flow<List<Event>> {
        return flow {
            emit(
                listOf(
                    Event(
                        id = 0,
                        name = "Встреча разработчиков",
                        date = "05.12.2024",
                        city = "Санкт-Петербург",
                        category = listOf("Python", "Junior", "Moscow"),
                        iconURL = "fsdfsdf",
                        isFinished = true
                    ),
                    Event(
                        id = 1,
                        name = "Встреча разработчиков",
                        date = "05.12.2024",
                        city = "Санкт-Петербург",
                        category = listOf("Python", "Junior", "Moscow"),
                        iconURL = "fsdfsdfsfd",
                        isFinished = false
                    ),
                )
            )
        }.flowOn(Dispatchers.IO)
    }

    override fun getEventDetail(eventId: Int): Flow<EventDetail> {
        return flow {
            emit(
                EventDetail(
                    id = 0,
                    name = "Встреча разработчиков Kotlon",
                    date = "13.09.2024",
                    address = EventAddress("Москва", "ул. Громова", "4"),
                    category = listOf("Python", "Junior", "Moscow"),
                    locationCoordinates = "115.22455 , 5554.15651",
                    description = "sdfsdfsdfsdfsddddddd",
                    listOfParticipants = listOf(
                        RegisteredPerson(0, null),
                        RegisteredPerson(1, "dfsdfsdf")
                    ),
                    isFinished = false,
                )
            )
        }.flowOn(Dispatchers.IO)
    }




    override suspend fun addUserAsParticipant(eventId: Int, participant: RegisteredPerson) {
        TODO("Not yet implemented")
    }

    override suspend fun removeUserAsParticipant(eventId: Int, participant: RegisteredPerson) {
        TODO("Not yet implemented")
    }
}