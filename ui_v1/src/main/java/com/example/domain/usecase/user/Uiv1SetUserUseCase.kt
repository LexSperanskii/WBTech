package com.example.domain.usecase.user

import com.example.domain.repositories.Uiv1IUserRepository

internal interface Uiv1SetUserUseCase {
    suspend fun execute(name: String, surname: String, avatarURL: String?)
}

internal class Uiv1SetUserUseCaseImpl(private val userRepository: Uiv1IUserRepository) :
    Uiv1SetUserUseCase {

    override suspend fun execute(name: String, surname: String, avatarURL: String?) {
        userRepository.setUser(name, surname, avatarURL)
    }
}