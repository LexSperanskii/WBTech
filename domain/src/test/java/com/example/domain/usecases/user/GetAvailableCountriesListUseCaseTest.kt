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
    fun setUp() {
        countriesRepositoryStub = CountriesRepositoryStub()
        useCase =
            GetAvailableCountriesListUseCaseImpl(countriesRepository = countriesRepositoryStub)
    }

    @Test
    fun `countries are unique`() = runTest {
        availableCountries = useCase.execute().first()
        val result = availableCountries.distinctBy { Triple(it.code, it.flag, it.country) }.size
        val expectedResult = availableCountries.size

        assertTrue(result == expectedResult) //проверяем уникальность
    }

    @Test
    fun `countries have not blank code`() = runTest {
        availableCountries = useCase.execute().first()
        availableCountries.forEach { country ->
            val result = country.code

            Assert.assertTrue(result.isNotBlank())
        }
    }

    @Test
    fun `countries have not blank name`() = runTest {
        availableCountries = useCase.execute().first()
        availableCountries.forEach { country ->
            val result = country.country

            Assert.assertTrue(country.country.isNotBlank())
        }
    }
}