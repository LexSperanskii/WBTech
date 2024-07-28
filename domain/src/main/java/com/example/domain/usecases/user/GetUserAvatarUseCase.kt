package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository
import kotlinx.coroutines.flow.Flow

interface GetUserAvatarUseCase {
    suspend fun execute(): Flow<String>
}

internal class GetUserAvatarInteractor(private val userRepository: IUserRepository) :
    GetUserAvatarUseCase {

    override suspend fun execute(): Flow<String> {
        return userRepository.getUserAvatar()
    }
}