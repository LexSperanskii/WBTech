package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository
import kotlinx.coroutines.flow.Flow

interface PinCodeVerificationUseCase {
    suspend fun execute(pinCode: Int): Boolean
}

internal class PinCodeVerificationInteractor(private val userRepository: IUserRepository) :
    PinCodeVerificationUseCase {

    override suspend fun execute(pinCode: Int): Boolean {
        return userRepository.pinCodeVerification(pinCode)
    }
}