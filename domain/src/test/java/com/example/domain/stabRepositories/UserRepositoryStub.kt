package com.example.domain.stabRepositories

import com.example.domain.models.PhoneNumber
import com.example.domain.models.User
import com.example.domain.repositories.IUserRepository
import com.example.domain.stabRepositories.StubData.phoneNumber
import com.example.domain.stabRepositories.StubData.user
import com.example.domain.stabRepositories.StubData.userAvatarURL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepositoryStub : IUserRepository {

    override fun getUserPhoneNumber(): Flow<PhoneNumber> {
        return flow {
            emit(
                phoneNumber
            )
        }.flowOn(Dispatchers.IO)
    }

    override fun getUserAvatar(): Flow<String> {
        return flow {
            emit(
                userAvatarURL
            )
        }.flowOn(Dispatchers.IO)
    }

    override fun getUser(): Flow<User> {
        return flow {
            emit(
                user
            )
        }.flowOn(Dispatchers.IO)
    }


    override fun pinCodeVerification(pinCode: String): Flow<Boolean> {
        TODO("Not yet implemented")
    }
    override suspend fun setUserPhoneNumber(code: String, number: String) {
        TODO("Not yet implemented")
    }
    override suspend fun setUser(name: String, surname: String, avatarURL: String?) {
        TODO("Not yet implemented")
    }
}