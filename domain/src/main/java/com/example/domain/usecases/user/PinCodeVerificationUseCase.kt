package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository

interface PinCodeVerificationUseCase {
    suspend fun execute(pinCode: String): Boolean
}

internal class PinCodeVerificationInteractor(private val userRepository: IUserRepository) :
    PinCodeVerificationUseCase {

    override suspend fun execute(pinCode: String): Boolean {
        return userRepository.pinCodeVerification(pinCode)
    }
}