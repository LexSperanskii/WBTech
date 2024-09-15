package com.example.domain.interactors.availableCountries

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadAvailableCountriesList {
    fun invoke()
}

internal class InteractorLoadAvailableCountriesListImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadAvailableCountriesList {

    override fun invoke() {
        useCase.loadAvailableCountriesList()
    }

}