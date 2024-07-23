package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository

interface SetUserSurnameUseCase {
    fun execute(surname: String)
}

internal class SetUserSurnameInteractor(private val userRepository: IUserRepository) :
    SetUserSurnameUseCase {

    override fun execute(surname: String) {
        userRepository.setUserSurname(surname)
    }
}