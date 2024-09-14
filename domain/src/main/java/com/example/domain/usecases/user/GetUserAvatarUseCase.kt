package com.example.domain.usecases.user

import com.example.domain.repositories.networkRepository.IUserRepository
import kotlinx.coroutines.flow.Flow

interface GetUserAvatarUseCase {
    fun execute(): Flow<String>
}

internal class GetUserAvatarUseCaseImpl(private val userRepository: IUserRepository) :
    GetUserAvatarUseCase {

    override fun execute(): Flow<String> {
        return userRepository.getUserAvatar()
    }
}