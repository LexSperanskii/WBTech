package com.example.domain.usecase.user

import com.example.domain.models.Uiv1PhoneNumber
import com.example.domain.repositories.Uiv1IUserRepository
import kotlinx.coroutines.flow.Flow

internal interface Uiv1GetUserPhoneNumberUseCase {
    fun execute(): Flow<Uiv1PhoneNumber>
}

internal class Uiv1GetUserPhoneNumberUseCaseImpl(private val userRepository: Uiv1IUserRepository) :
    Uiv1GetUserPhoneNumberUseCase {
    override fun execute(): Flow<Uiv1PhoneNumber> {
        return userRepository.getUserPhoneNumber()
    }
}