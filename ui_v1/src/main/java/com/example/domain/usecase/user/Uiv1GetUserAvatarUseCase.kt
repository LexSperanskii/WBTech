package com.example.domain.usecase.user

import com.example.domain.repositories.Uiv1IUserRepository
import kotlinx.coroutines.flow.Flow

internal interface Uiv1GetUserAvatarUseCase {
    fun execute(): Flow<String>
}

internal class Uiv1GetUserAvatarUseCaseImpl(private val userRepository: Uiv1IUserRepository) :
    Uiv1GetUserAvatarUseCase {

    override fun execute(): Flow<String> {
        return userRepository.getUserAvatar()
    }
}