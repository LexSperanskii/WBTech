package com.example.domain.usecases.user

import com.example.domain.models.User
import com.example.domain.repositories.IUserRepository


interface GetUserUseCase {
    fun execute(): User
}

internal class GetUserInteractor(private val userRepository: IUserRepository) :
    GetUserUseCase {
    override fun execute(): User {
        return userRepository.getUser()
    }
}