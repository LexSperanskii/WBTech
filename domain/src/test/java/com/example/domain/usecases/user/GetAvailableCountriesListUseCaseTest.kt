package com.example.domain.usecases.user

import com.example.domain.models.Country
import com.example.domain.stabRepositories.CountriesRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue

class GetAvailableCountriesListUseCaseTest {

    private lateinit var countriesRepositoryStub: CountriesRepositoryStub
    private lateinit var useCase: GetAvailableCountriesListUseCaseImpl
    private lateinit var availableCountries: List<Country>

    @Before
    fun setUp() = runTest {
        countriesRepositoryStub = CountriesRepositoryStub()
        useCase =
            GetAvailableCountriesListUseCaseImpl(countriesRepository = countriesRepositoryStub)
        availableCountries = useCase.execute().first()
    }

    @Test
    fun `countries are unique`() {
        assertTrue(availableCountries.distinctBy { Triple(it.code, it.flag, it.country) }.size == availableCountries.size) //проверяем уникальность
    }

    @Test
    fun `countries have not blank code`() {
        availableCountries.forEach { country ->
            Assert.assertTrue(country.code.isNotBlank())
        }
    }

    @Test
    fun `countries have not blank name`() {
        availableCountries.forEach { country ->
            Assert.assertTrue(country.country.isNotBlank())
        }
    }
}