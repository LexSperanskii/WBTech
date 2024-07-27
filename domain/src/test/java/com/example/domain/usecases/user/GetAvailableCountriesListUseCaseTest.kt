package com.example.domain.usecases.user

import com.example.domain.stabRepositories.TestCountriesRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

class GetAvailableCountriesListUseCaseTest {

    @Test
    fun `return correct countries list`() = runTest{

        val testCountriesRepository = TestCountriesRepository()

        val useCase = GetAvailableCountriesListInteractor(countriesRepository = testCountriesRepository)

        val availableCountries = useCase.execute().first()

        assertNotNull(availableCountries)
        availableCountries.forEach { country ->
            assertNotNull(country.code)
            assertTrue(country.code.isNotEmpty())
            assertTrue(country.code.isNotBlank())
            assertNotNull(country.flag)
            assertTrue(country.flag.isNotEmpty())
            assertTrue(country.flag.isNotBlank())
            assertNotNull(country.country)
            assertTrue(country.country.isNotEmpty())
            assertTrue(country.country.isNotBlank())
        }
    }


}