package com.example.data.repositoriesImpl

import com.example.domain.models.MockData
import com.example.domain.models.PhoneNumber
import com.example.domain.repositories.IUserRepository

class UserRepositoryImpl(private val mock: MockData): IUserRepository {

    override fun setUserPhoneNumber(code: String, number: String) {
        mock.setUserPhoneNumber(code,number)
    }

    override fun getUserAvatar(): String {
        return mock.getUserAvatar()
    }

    override fun setUserName(name: String) {
        mock.setUserName(name)
    }

    override fun setUserSurname(surname: String) {
        mock.setUserSurname(surname)
    }

    override fun setUserAvatar(avatarURL: String?) {
        mock.setUserAvatar(avatarURL)
    }

    override fun getUserPhoneNumber(): PhoneNumber {
        return mock.getUserPhoneNumber()
    }

}