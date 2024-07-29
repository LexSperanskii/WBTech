package com.example.spa_wb_junior_devmeetingapp.models

internal data class UserModelUI(
    val id: Int = 0,
    val name: String = "",
    val surname: String = "",
    val phoneNumberModelUI: PhoneNumberModelUI = PhoneNumberModelUI(),
    val iconURL: String? = ""
)