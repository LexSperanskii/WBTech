package com.example.domain.repositories

import com.example.domain.models.PhoneNumber
import com.example.domain.models.User

interface IUserRepository {

    fun setUserPhoneNumber(code: String, number: String)

    fun getUserAvatar(): String
    fun setUserName(name: String)
    fun setUserSurname(surname: String)
    fun setUserAvatar(avatarURL: String?)
    fun getUserPhoneNumber() : PhoneNumber
    fun getUser(): User
}