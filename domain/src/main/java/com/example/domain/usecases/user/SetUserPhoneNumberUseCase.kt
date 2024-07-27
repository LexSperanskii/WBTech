package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository


interface SetUserPhoneNumberUseCase {
    suspend fun execute(code: String, number: String)
}

internal class SetUserPhoneNumberInteractor(private val userRepository: IUserRepository) : SetUserPhoneNumberUseCase {

    override suspend fun execute(code: String, number: String) {
        userRepository.setUserPhoneNumber(code,number)
    }
}