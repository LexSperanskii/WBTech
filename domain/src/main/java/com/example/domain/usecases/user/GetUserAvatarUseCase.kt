package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository

interface GetUserAvatarUseCase {
    suspend fun execute(): String
}

internal class GetUserAvatarInteractor(private val userRepository: IUserRepository) :
    GetUserAvatarUseCase {

    override suspend fun execute(): String {
        return userRepository.getUserAvatar()
    }
}