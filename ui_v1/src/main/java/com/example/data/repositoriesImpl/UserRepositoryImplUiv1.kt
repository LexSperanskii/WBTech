package com.example.data.repositoriesImpl

import com.example.domain.models.Uiv1MockData
import com.example.domain.models.Uiv1PhoneNumber
import com.example.domain.models.Uiv1User
import com.example.domain.repositories.Uiv1IUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class UserRepositoryImplUiv1(private val mock: Uiv1MockData = Uiv1MockData()) :
    Uiv1IUserRepository {

    override suspend fun setUserPhoneNumber(code: String, number: String) {
        mock.setUserPhoneNumber(code, number)
    }

    override fun getUserPhoneNumber(): Flow<Uiv1PhoneNumber> {
        return flow {
            emit(mock.getUserPhoneNumber())
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun setUserPinCode(pinCode: String) {
        mock.setUserPinCode(pinCode)
    }

    override fun getPinCodeVerification(): Flow<Boolean> {
        return flow {
            emit(mock.pinCodeVerification())
        }.flowOn(Dispatchers.IO)
    }

    override fun getUserAvatar(): Flow<String> {
        return flow {
            emit(mock.getUserAvatar())
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun setUser(name: String, surname: String, avatarURL: String?) {
        mock.setUserName(name)
        mock.setUserSurname(surname)
        mock.setUserAvatar(avatarURL)
    }

    override fun getUser(): Flow<Uiv1User> {
        return flow {
            emit(mock.getUser())
        }.flowOn(Dispatchers.IO)
    }

}