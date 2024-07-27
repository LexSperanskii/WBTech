package com.example.domain.repositories

import com.example.domain.models.PhoneNumber
import com.example.domain.models.User
import kotlinx.coroutines.flow.Flow

interface IUserRepository {

    suspend fun setUserPhoneNumber(code: String, number: String)

    suspend fun getUserPhoneNumber() : PhoneNumber

    suspend fun pinCodeVerification(pinCode: String) : Boolean

    suspend fun getUserAvatar(): String

    suspend fun setUser(name: String,surname: String,avatarURL: String?)

    fun getUser(): Flow<User>

}