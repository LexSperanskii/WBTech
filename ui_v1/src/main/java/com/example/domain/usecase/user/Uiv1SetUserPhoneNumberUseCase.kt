package com.example.domain.usecase.user

import com.example.domain.repositories.Uiv1IUserRepository


internal interface Uiv1SetUserPhoneNumberUseCase {
    suspend fun execute(code: String, number: String)
}

internal class Uiv1SetUserPhoneNumberUseCaseImpl(private val userRepository: Uiv1IUserRepository) :
    Uiv1SetUserPhoneNumberUseCase {

    override suspend fun execute(code: String, number: String) {
        userRepository.setUserPhoneNumber(code, number)
    }
}