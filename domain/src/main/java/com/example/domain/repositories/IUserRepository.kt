package com.example.domain.repositories

import com.example.domain.models.Country
import com.example.domain.models.PhoneNumber

interface IUserRepository {

    fun getAvailableCountriesList(): List<Country>

    fun savePhoneNumber(phoneNumber: PhoneNumber)

    fun getPhoneNumber(): PhoneNumber
}