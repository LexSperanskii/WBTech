package com.example.data.repositoriesImpl

import com.example.domain.models.Country
import com.example.domain.models.MockData
import com.example.domain.repositories.ICountriesRepository

internal class CountriesRepositoryImpl(private val mock: MockData) : ICountriesRepository {
    override fun getAvailableCountriesList(): List<Country> {
        return mock.getAvailableCountries()
    }
}