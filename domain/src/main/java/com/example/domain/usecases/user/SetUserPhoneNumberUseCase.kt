package com.example.domain.usecases.user

import com.example.domain.repositories.networkRepository.IUserRepository


interface SetUserPhoneNumberUseCase {
    suspend fun execute(code: String, number: String)
}

internal class SetUserPhoneNumberUseCaseImpl(private val userRepository: IUserRepository) :
    SetUserPhoneNumberUseCase {

    override suspend fun execute(code: String, number: String) {
        userRepository.setUserPhoneNumber(code,number)
    }
}