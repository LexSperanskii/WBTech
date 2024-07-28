package com.example.domain.usecases.user

import com.example.domain.models.Country
import com.example.domain.repositories.ICountriesRepository
import kotlinx.coroutines.flow.Flow

interface GetAvailableCountriesListUseCase {
    fun execute(): Flow<List<Country>>
}

internal class GetAvailableCountriesListInteractor(private val countriesRepository: ICountriesRepository) :
    GetAvailableCountriesListUseCase {

    override fun execute(): Flow<List<Country>>{
        return countriesRepository.getAvailableCountriesList()
    }
}