package com.example.domain.interactors.availableCountries

import com.example.domain.models.CountryModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetAvailableCountriesList {
    fun invoke(): Flow<List<CountryModelDomain>>
}

internal class InteractorGetAvailableCountriesListImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetAvailableCountriesList {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val availableCountriesListFlow = useCase.observeAvailableCountriesList().flatMapLatest {
        networkRepository.getAvailableCountriesList()
    }

    override fun invoke(): Flow<List<CountryModelDomain>> = availableCountriesListFlow
}