package com.example.domain.model

data class User(
    val id: Int,
    val name: String,
    val surname: String,
    val phoneNumber: PhoneNumber,
    val iconURL: String?
)