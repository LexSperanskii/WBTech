package com.example.domain.repositories

import com.example.domain.models.Uiv1Country
import kotlinx.coroutines.flow.Flow


internal interface Uiv1ICountriesRepository {

    fun getAvailableCountriesList(): Flow<List<Uiv1Country>>

}