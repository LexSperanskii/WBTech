package com.example.domain.usecases.user

import com.example.domain.repositories.networkRepository.IUserRepository
import kotlinx.coroutines.flow.Flow

interface GetPinCodeVerificationUseCase {
    fun execute(): Flow<Boolean>
}

internal class GetPinCodeVerificationUseCaseImpl(private val userRepository: IUserRepository) :
    GetPinCodeVerificationUseCase {

    override fun execute(): Flow<Boolean> {
        return userRepository.getPinCodeVerification()
    }
}