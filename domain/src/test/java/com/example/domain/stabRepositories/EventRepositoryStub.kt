package com.example.domain.stabRepositories

//import com.example.domain.models.EventDetail
//import com.example.domain.models.RegisteredPerson
//import com.example.domain.repositories.networkRepository.IEventRepository
//import com.example.domain.stabRepositories.StubData.eventDetail
//import com.example.domain.stabRepositories.StubData.eventsList
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.flowOn
//
//class EventRepositoryStub : IEventRepository {
//    override fun getListOfEvents(): Flow<List<Event>> {
//        return flow {
//            emit(
//                eventsList
//            )
//        }.flowOn(Dispatchers.IO)
//    }
//
//    override fun getEventDetail(eventId: Int): Flow<EventDetail> {
//        return flow {
//            emit(
//                eventDetail
//            )
//        }.flowOn(Dispatchers.IO)
//    }
//
//
//
//
//    override suspend fun addUserAsParticipant(eventId: Int, participant: RegisteredPerson) {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun removeUserAsParticipant(eventId: Int, participant: RegisteredPerson) {
//        TODO("Not yet implemented")
//    }
//}