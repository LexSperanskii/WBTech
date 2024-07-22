package com.example.domain.repositories

import com.example.domain.models.PhoneNumber

interface IUserRepository {

    fun setUserPhoneNumber(code: String, number: String)

    fun getUserAvatar(): String
    fun setUserName(name: String)
    fun setUserSurname(surname: String)
    fun setUserAvatar(avatarURL: String?)
    fun getUserPhoneNumber() : PhoneNumber
}