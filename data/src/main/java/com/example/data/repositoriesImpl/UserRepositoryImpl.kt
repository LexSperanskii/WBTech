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

    override fun getUserPhoneNumber(): Flow<PhoneNumber> {
        return flow{
            emit(mock.getUserPhoneNumber())
        }.flowOn(Dispatchers.IO)
    }

    override fun pinCodeVerification(pinCode: String) : Flow<Boolean> {
        return flow{
            emit(mock.pinCodeVerification(pinCode))
        }.flowOn(Dispatchers.IO)
    }

    override fun getUserAvatar(): Flow<String> {
        return flow{
            emit(mock.getUserAvatar())
        }.flowOn(Dispatchers.IO)
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