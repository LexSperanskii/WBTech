package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository


interface SetUserPhoneNumberUseCase {
    fun execute(code: String, number: String)
}

internal class SetUserPhoneNumberInteractor(private val userRepository: IUserRepository) : SetUserPhoneNumberUseCase {

    override fun execute(code: String, number: String) {
        userRepository.setUserPhoneNumber(code,number)
    }
}