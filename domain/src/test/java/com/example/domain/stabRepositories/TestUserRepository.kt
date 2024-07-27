package com.example.domain.stabRepositories

import com.example.domain.models.PhoneNumber
import com.example.domain.models.User
import com.example.domain.repositories.IUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TestUserRepository : IUserRepository {

    override suspend fun getUserPhoneNumber(): PhoneNumber {
        return PhoneNumber("+7", "0000000000")
    }

    override suspend fun pinCodeVerification(pinCode: Int): Boolean {
        return true
    }

    override suspend fun getUserAvatar(): String {
        return "sdfsdfsdfsdfsdfsdf"
    }

    override fun getUser(): Flow<User> {
        return flow {
            emit(
                User(
                    id = 0,
                    name = "GGG",
                    surname = "HHH",
                    phoneNumber = PhoneNumber("+7", "0000000000"),
                    iconURL = null
                )
            )
        }.flowOn(Dispatchers.IO)
    }



    override suspend fun setUserPhoneNumber(code: String, number: String) {
        TODO("Not yet implemented")
    }
    override suspend fun setUser(name: String, surname: String, avatarURL: String?) {
        TODO("Not yet implemented")
    }
}