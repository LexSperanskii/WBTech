package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository

interface SetUserUseCase {
    suspend fun execute(name: String,surname: String,avatarURL: String?)
}

internal class SetUserUseCaseImpl(private val userRepository: IUserRepository) :
    SetUserUseCase {

    override suspend fun execute(name: String,surname: String,avatarURL: String?) {
        userRepository.setUser(name,surname,avatarURL )
    }
}