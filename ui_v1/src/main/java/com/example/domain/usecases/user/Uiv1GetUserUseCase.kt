package com.example.domain.usecases.user

import com.example.domain.models.Uiv1User
import com.example.domain.repositories.Uiv1IUserRepository
import kotlinx.coroutines.flow.Flow


internal interface Uiv1GetUserUseCase {
    fun execute(): Flow<Uiv1User>
}

internal class Uiv1GetUserUseCaseImpl(private val userRepository: Uiv1IUserRepository) :
    Uiv1GetUserUseCase {
    override fun execute(): Flow<Uiv1User> {
        return userRepository.getUser()
    }
}