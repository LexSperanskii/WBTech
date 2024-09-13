package com.example.domain.repositories

import kotlinx.coroutines.flow.Flow


interface ICountriesRepository {

    fun getAvailableCountriesList(): Flow<List<Country>>

}