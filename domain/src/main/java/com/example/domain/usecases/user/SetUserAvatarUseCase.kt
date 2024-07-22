package com.example.domain.usecases.user

import com.example.domain.repositories.IUserRepository


interface SetUserAvatarUseCase {
    fun execute(avatarURL: String?)
}

internal class SetUserAvatarInteractor(private val userRepository: IUserRepository) :
    SetUserAvatarUseCase {

    override fun execute(avatarURL: String?) {
        userRepository.setUserAvatar(avatarURL)
    }
}