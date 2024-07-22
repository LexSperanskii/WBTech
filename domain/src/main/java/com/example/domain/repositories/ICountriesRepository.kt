package com.example.domain.repositories

import com.example.domain.models.Country


interface ICountriesRepository {
    fun getAvailableCountriesList(): List<Country>
}