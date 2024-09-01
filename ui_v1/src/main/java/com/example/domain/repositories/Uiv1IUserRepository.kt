package com.example.domain.repositories

import com.example.domain.models.Uiv1PhoneNumber
import com.example.domain.models.Uiv1User
import kotlinx.coroutines.flow.Flow

internal interface Uiv1IUserRepository {

    suspend fun setUserPhoneNumber(code: String, number: String)

    fun getUserPhoneNumber(): Flow<Uiv1PhoneNumber>

    suspend fun setUserPinCode(pinCode: String)

    fun getPinCodeVerification(): Flow<Boolean>

    fun getUserAvatar(): Flow<String>

    suspend fun setUser(name: String, surname: String, avatarURL: String?)

    fun getUser(): Flow<Uiv1User>

}