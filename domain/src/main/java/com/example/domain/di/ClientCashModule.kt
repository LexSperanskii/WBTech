package com.example.domain.di

import com.example.domain.interactors.ClientCash.IInteractorGetClientCash
import com.example.domain.interactors.ClientCash.IInteractorSaveClientCash
import com.example.domain.interactors.ClientCash.InteractorGetClientCashImpl
import com.example.domain.interactors.ClientCash.InteractorSaveClientCashImpl
import org.koin.dsl.module

val clientCashModule = module {

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