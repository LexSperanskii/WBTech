package com.example.domain.stabRepositories

import com.example.domain.models.Community
import com.example.domain.models.CommunityDetail
import com.example.domain.models.Country
import com.example.domain.models.Event
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
                    Country("Russia", "+7", ""),
                    Country("Kz", "+7", ""),
                    Country("Gb", "+44", "")
                )
            )
        }.flowOn(Dispatchers.IO)
    }
}