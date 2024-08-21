package com.example.spa_wb_junior_devmeetingapp.models

import androidx.annotation.DrawableRes

internal data class CountryModelUI(
    val country : String = "",
    val code : String = "",
    val flag : String = ""
)

internal data class NewCountryModelUI(
    val country: String,
    val code: String,
    @DrawableRes
    val flag: Int
)