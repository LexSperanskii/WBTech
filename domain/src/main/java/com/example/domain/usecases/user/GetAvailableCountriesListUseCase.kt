package com.example.domain.usecases.user

import com.example.domain.models.Country
import com.example.domain.repositories.ICountriesRepository

interface GetAvailableCountriesListUseCase {
    fun execute(): List<Country>
}

internal class GetAvailableCountriesListInteractor(private val countriesRepository: ICountriesRepository) :
    GetAvailableCountriesListUseCase {

    override fun execute(): List<Country>{
        return countriesRepository.getAvailableCountriesList()
    }
}