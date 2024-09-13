package com.example.domain.repositories

import kotlinx.coroutines.flow.Flow

interface IUserRepository {

    suspend fun setUserPhoneNumber(code: String, number: String)

    fun getUserPhoneNumber() : Flow<PhoneNumber>

    suspend fun setUserPinCode(pinCode: String)

    fun getPinCodeVerification(): Flow<Boolean>

    fun getUserAvatar(): Flow<String>

    suspend fun setUser(name: String,surname: String,avatarURL: String?)

    fun getUser(): Flow<User>

}