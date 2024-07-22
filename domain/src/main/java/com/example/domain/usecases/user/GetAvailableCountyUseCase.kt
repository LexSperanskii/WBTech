package com.example.domain.usecases.user

import com.example.domain.models.Country
import com.example.domain.repositories.ICountriesRepository


interface GetAvailableCountyUseCase {
    fun execute(): Country
}

internal class GetAvailableCountyInteractor(private val countriesRepository: ICountriesRepository) :
    GetAvailableCountyUseCase {

    override fun execute() : Country{
        return countriesRepository.getAvailableCountriesList()[0]
    }
}