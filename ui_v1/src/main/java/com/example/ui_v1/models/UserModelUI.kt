package com.example.ui_v1.models

internal data class UserModelUI(
    val id: Int = 0,
    val name: String = "",
    val surname: String = "",
    val phoneNumberModelUI: PhoneNumberModelUI = PhoneNumberModelUI(),
    val iconURL: String? = "",
)