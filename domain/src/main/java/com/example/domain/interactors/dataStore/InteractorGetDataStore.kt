package com.example.domain.interactors.dataStore

import com.example.domain.repositories.IDataStoreRepository
import kotlinx.coroutines.flow.Flow


interface IInteractorGetDataStore {
    fun invoke(key: String, defaultValue: String = ""): Flow<String>
}

internal class InteractorGetDataStoreImpl(
    private val datastoreRepository: IDataStoreRepository,
) : IInteractorGetDataStore {

    override fun invoke(key: String, defaultValue: String): Flow<String> {
        return datastoreRepository.getString(key, defaultValue)
    }

}