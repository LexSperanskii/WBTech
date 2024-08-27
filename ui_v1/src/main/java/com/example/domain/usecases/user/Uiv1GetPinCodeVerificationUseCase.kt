package com.example.domain.usecases.user

import com.example.domain.repositories.Uiv1IUserRepository
import kotlinx.coroutines.flow.Flow

internal interface Uiv1GetPinCodeVerificationUseCase {
    fun execute(): Flow<Boolean>
}

internal class Uiv1GetPinCodeVerificationUseCaseImpl(private val userRepository: Uiv1IUserRepository) :
    Uiv1GetPinCodeVerificationUseCase {

    override fun execute(): Flow<Boolean> {
        return userRepository.getPinCodeVerification()
    }
}