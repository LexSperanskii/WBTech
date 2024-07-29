package com.example.domain.stabRepositories

import com.example.domain.models.Country
import com.example.domain.repositories.ICountriesRepository
import com.example.domain.stabRepositories.StubData.countiesList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CountriesRepositoryStub : ICountriesRepository {
    override fun getAvailableCountriesList(): Flow<List<Country>> {
        return flow {
            emit(
                countiesList
            )
        }.flowOn(Dispatchers.IO)
    }
}