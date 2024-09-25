package com.example.domain.interactors.dataStore

import com.example.domain.repositories.IDataStoreRepository


interface IInteractorClearDataStore {
    suspend fun invoke()
}

internal class InteractorClearDataStoreImpl(
    private val datastoreRepository: IDataStoreRepository,
) : IInteractorClearDataStore {

    override suspend fun invoke() {
        datastoreRepository.clearDataStore()
    }
}