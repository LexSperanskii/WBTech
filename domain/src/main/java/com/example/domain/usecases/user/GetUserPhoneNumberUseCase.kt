package com.example.domain.usecases.user

import com.example.domain.models.PhoneNumber
import com.example.domain.repositories.IUserRepository

interface GetUserPhoneNumberUseCase {
    fun execute(): PhoneNumber
}

internal class GetUserPhoneNumberInteractor(private val userRepository: IUserRepository) :
    GetUserPhoneNumberUseCase {
    override fun execute(): PhoneNumber {
        return userRepository.getUserPhoneNumber()
    }


}