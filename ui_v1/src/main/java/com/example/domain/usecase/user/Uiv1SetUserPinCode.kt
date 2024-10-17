package com.example.domain.usecase.user

import com.example.domain.repositories.Uiv1IUserRepository

internal interface Uiv1SetUserPinCodeUseCase {
    suspend fun execute(pinCode: String)
}

internal class Uiv1SetUserPinCodeUseCaseImpl(private val userRepository: Uiv1IUserRepository) :
    Uiv1SetUserPinCodeUseCase {

    override suspend fun execute(pinCode: String) {
        return userRepository.setUserPinCode(pinCode)
    }
}