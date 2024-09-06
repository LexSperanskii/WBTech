package com.example.ui_v2.models

import androidx.annotation.DrawableRes

internal data class CountryModelUI(
    val country: String = "",
    val code: String = "",
    @DrawableRes
    val flag: Int = 0,
)