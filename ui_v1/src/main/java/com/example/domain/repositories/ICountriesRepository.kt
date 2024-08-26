package com.example.domain.repositories

import com.example.domain.models.Country
import kotlinx.coroutines.flow.Flow


interface ICountriesRepository {

    fun getAvailableCountriesList(): Flow<List<Country>>

}