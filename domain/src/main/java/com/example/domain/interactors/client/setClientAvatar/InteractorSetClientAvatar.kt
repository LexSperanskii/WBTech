package com.example.domain.interactors.client.setClientAvatar

import com.example.domain.usecase.ClientUseCase


interface IInteractorSetClientAvatar {
    fun invoke(imageURL: String?)
}

internal class InteractorSetClientAvatarImpl(
    private val useCase: ClientUseCase,
) : IInteractorSetClientAvatar {

    override fun invoke(imageURL: String?) {
        useCase.setClientAvatar(imageURL)
    }

}