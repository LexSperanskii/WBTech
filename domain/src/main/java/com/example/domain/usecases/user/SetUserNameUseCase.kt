package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository

interface SetUserNameUseCase {
    fun execute(name: String)
}

internal class SetUserNameInteractor(private val userRepository: IUserRepository) :
    SetUserNameUseCase {

    override fun execute(name: String) {
        userRepository.setUserName(name)
    }
}