package com.example.domain.usecases.user

import com.example.domain.models.PhoneNumber
import com.example.domain.repositories.IUserRepository
import kotlinx.coroutines.flow.Flow

interface GetUserPhoneNumberUseCase {
    fun execute(): Flow<PhoneNumber>
}

internal class GetUserPhoneNumberInteractor(private val userRepository: IUserRepository) :
    GetUserPhoneNumberUseCase {
    override fun execute(): Flow<PhoneNumber> {
        return userRepository.getUserPhoneNumber()
    }
}