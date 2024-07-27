package com.example.domain.stabRepositories

import com.example.domain.models.Country
import com.example.domain.repositories.ICountriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TestCountriesRepository : ICountriesRepository {
    override fun getAvailableCountriesList(): Flow<List<Country>> {
        return flow {
            emit(
                listOf(
                    Country("Russia", "+7", "ggsfgsfg"),
                    Country("Kz", "+7", "sgsgsdfg"),
                    Country("Gb", "+44", "sdgsdfgsdg")
                )
            )
        }.flowOn(Dispatchers.IO)
    }
}