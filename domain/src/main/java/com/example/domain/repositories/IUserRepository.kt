package com.example.domain.repositories

import com.example.domain.models.PhoneNumber
import com.example.domain.models.User
import kotlinx.coroutines.flow.Flow

interface IUserRepository {

    suspend fun setUserPhoneNumber(code: String, number: String)

    fun getUserPhoneNumber() : Flow<PhoneNumber>

    fun pinCodeVerification(pinCode: String) : Flow<Boolean>

    fun getUserAvatar(): Flow<String>

    suspend fun setUser(name: String,surname: String,avatarURL: String?)

    fun getUser(): Flow<User>

}