package com.example.ui_v1.models

internal data class UIv1UserModelUI(
    val id: Int = 0,
    val name: String = "",
    val surname: String = "",
    val uiv1PhoneNumberModelUI: UIv1PhoneNumberModelUI = UIv1PhoneNumberModelUI(),
    val iconURL: String? = "",
)