package com.example.domain.interactors.dataStore

import com.example.domain.repositories.IDataStoreRepository


interface IInteractorSetDataStore {
    suspend fun invoke(key: String, value: String)
}

internal class InteractorSetDataStoreImpl(
    private val datastoreRepository: IDataStoreRepository,
) : IInteractorSetDataStore {

    override suspend fun invoke(key: String, value: String) {
        datastoreRepository.setString(key, value)
    }
}