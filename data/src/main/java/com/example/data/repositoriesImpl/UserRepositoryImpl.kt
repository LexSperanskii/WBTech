package com.example.data.repositoriesImpl

import com.example.domain.models.MockData
import com.example.domain.models.PhoneNumber
import com.example.domain.models.User
import com.example.domain.repositories.IUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class UserRepositoryImpl(private val mock: MockData): IUserRepository {

    override suspend fun setUserPhoneNumber(code: String, number: String) {
        mock.setUserPhoneNumber(code,number)
    }

    override suspend fun getUserPhoneNumber(): PhoneNumber {
        return mock.getUserPhoneNumber()
    }

    override suspend fun pinCodeVerification(pinCode: Int) : Boolean {
        return mock.pinCodeVerification(pinCode)
    }

    override suspend fun getUserAvatar(): String {
        return mock.getUserAvatar()
    }

    override suspend fun setUser(name: String, surname: String, avatarURL: String?) {
        mock.setUserName(name)
        mock.setUserSurname(surname)
        mock.setUserAvatar(avatarURL)
    }

    override fun getUser(): Flow<User> {
        return flow {
            emit(mock.getUser())
        }.flowOn(Dispatchers.IO)
    }

}