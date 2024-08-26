package com.example.data.repositoriesImpl

import com.example.domain.models.Country
import com.example.domain.models.MockData
import com.example.domain.repositories.ICountriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class CountriesRepositoryImpl(private val mock: MockData) : ICountriesRepository {

    override fun getAvailableCountriesList(): Flow<List<Country>> {
        return flow {
            emit(mock.getAvailableCountries())
        }.flowOn(Dispatchers.IO)
    }

}