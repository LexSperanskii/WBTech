package com.example.ui_v2.models

internal data class UserModelUI(
    val id: String = "",
    val name: String = "",
    val surname: String = "",
    val tag: String = "",
    val description: String = "",
    val imageURL: String? = "",
)

internal data class ClientModelUI(
    val name: String = "",
    val surname: String = "",
    val countryCode: String = "",
    val number: String = "",
)