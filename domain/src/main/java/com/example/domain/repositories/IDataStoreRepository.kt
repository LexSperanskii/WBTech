package com.example.domain.repositories

import kotlinx.coroutines.flow.Flow

interface IDataStoreRepository {
    suspend fun setString(key: String, value: String)
    fun getString(key: String, defaultValue: String): Flow<String>
    suspend fun clearDataStore()
}