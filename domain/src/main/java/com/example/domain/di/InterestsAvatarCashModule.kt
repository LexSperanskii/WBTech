package com.example.domain.di


import com.example.domain.interactors.interestsAvatarCash.avatar.IInteractorGetClientCash
import com.example.domain.interactors.interestsAvatarCash.avatar.IInteractorSaveClientCash
import com.example.domain.interactors.interestsAvatarCash.avatar.InteractorGetClientCashImpl
import com.example.domain.interactors.interestsAvatarCash.avatar.InteractorSaveClientCashImpl
import org.koin.dsl.module

val interestsAvatarCashModule = module {

    single<IInteractorGetClientCash> {
        InteractorGetClientCashImpl(
            cashRepository = get()
        )
    }
    single<IInteractorSaveClientCash> {
        InteractorSaveClientCashImpl(
            cashRepository = get()
        )
    }

}