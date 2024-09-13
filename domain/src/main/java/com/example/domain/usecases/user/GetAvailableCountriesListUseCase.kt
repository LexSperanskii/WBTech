package com.example.domain.usecases.user

import com.example.domain.repositories.ICountriesRepository
import kotlinx.coroutines.flow.Flow

interface GetAvailableCountriesListUseCase {
    fun execute(): Flow<List<Country>>
}

internal class GetAvailableCountriesListUseCaseImpl(private val countriesRepository: ICountriesRepository) :
    GetAvailableCountriesListUseCase {

    override fun execute(): Flow<List<Country>>{
        return countriesRepository.getAvailableCountriesList()
    }
}