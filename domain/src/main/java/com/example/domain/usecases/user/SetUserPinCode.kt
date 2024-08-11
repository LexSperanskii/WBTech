package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository

interface SetUserPinCodeUseCase {
    suspend fun execute(pinCode: String)
}

internal class SetUserPinCodeUseCaseImpl(private val userRepository: IUserRepository) :
    SetUserPinCodeUseCase {

    override suspend fun execute(pinCode: String) {
        return userRepository.setUserPinCode(pinCode)
    }
}