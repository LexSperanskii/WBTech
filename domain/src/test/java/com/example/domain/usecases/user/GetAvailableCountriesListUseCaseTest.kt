package com.example.domain.usecases.user

import com.example.domain.stabRepositories.CountriesRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

class GetAvailableCountriesListUseCaseTest {

    @Test
    fun `return correct countries list`() = runTest{

        val countriesRepositoryStub = CountriesRepositoryStub()

        val useCase = GetAvailableCountriesListInteractor(countriesRepository = countriesRepositoryStub)

        val availableCountries = useCase.execute().first()

        assertTrue(availableCountries.distinctBy { Triple(it.code, it.flag, it.country) }.size == availableCountries.size) //проверяем уникальность
    }
}