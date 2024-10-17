package com.example.ui_v2.models


internal data class PhoneNumberModelUI(
    val country: CountryModelUI = CountryModelUI(),
    val number: String = "",
)