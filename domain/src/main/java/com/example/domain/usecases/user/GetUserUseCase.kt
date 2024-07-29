package com.example.domain.usecases.user

import com.example.domain.models.User
import com.example.domain.repositories.IUserRepository
import kotlinx.coroutines.flow.Flow


interface GetUserUseCase {
    fun execute(): Flow<User>
}

internal class GetUserUseCaseImpl(private val userRepository: IUserRepository) :
    GetUserUseCase {
    override fun execute(): Flow<User> {
        return userRepository.getUser()
    }
}