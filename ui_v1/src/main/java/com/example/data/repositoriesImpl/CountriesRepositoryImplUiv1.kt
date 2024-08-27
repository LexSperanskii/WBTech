package com.example.data.repositoriesImpl

import com.example.domain.models.Uiv1Country
import com.example.domain.models.Uiv1MockData
import com.example.domain.repositories.Uiv1ICountriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class CountriesRepositoryImplUiv1(private val mock: Uiv1MockData) :
    Uiv1ICountriesRepository {

    override fun getAvailableCountriesList(): Flow<List<Uiv1Country>> {
        return flow {
            emit(mock.getAvailableCountries())
        }.flowOn(Dispatchers.IO)
    }

}