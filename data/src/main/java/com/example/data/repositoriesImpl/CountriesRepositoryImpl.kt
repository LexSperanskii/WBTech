package com.example.data.repositoriesImpl

import com.example.domain.models.Country
import com.example.domain.models.MockData
import com.example.domain.models.PhoneNumber
import com.example.domain.repositories.IUserRepository



class UserRepositoryImpl(private val mock: MockData) : IUserRepository {

//    override fun getAvailableCountriesList(): List<Country> {
//        return mock.getAvailableCountries()
//    }
//
//    override fun savePhoneNumber(phoneNumber: PhoneNumber) {
//        mock.setUserPhoneNumber(phoneNumber)
//    }
//
//    override fun getPhoneNumber(): PhoneNumber {
//        return mock.getUserPhoneNumber()
//    }
}