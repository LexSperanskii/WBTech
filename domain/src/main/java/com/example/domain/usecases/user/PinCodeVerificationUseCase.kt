package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository
import kotlinx.coroutines.flow.Flow

interface PinCodeVerificationUseCase {
    fun execute(pinCode: String): Flow<Boolean>
}

internal class PinCodeVerificationUseCaseImpl(private val userRepository: IUserRepository) :
    PinCodeVerificationUseCase {

    override fun execute(pinCode: String): Flow<Boolean> {
        return userRepository.pinCodeVerification(pinCode)
    }
}