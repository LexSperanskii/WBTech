package com.example.domain.usecase.user

import com.example.domain.models.Uiv1Country
import com.example.domain.repositories.Uiv1ICountriesRepository
import kotlinx.coroutines.flow.Flow

internal interface Uiv1GetAvailableCountriesListUseCase {
    fun execute(): Flow<List<Uiv1Country>>
}

internal class Uiv1GetAvailableCountriesListUseCaseImpl(private val countriesRepository: Uiv1ICountriesRepository) :
    Uiv1GetAvailableCountriesListUseCase {

    override fun execute(): Flow<List<Uiv1Country>> {
        return countriesRepository.getAvailableCountriesList()
    }
}