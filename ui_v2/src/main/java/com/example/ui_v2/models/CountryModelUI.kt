package com.example.ui_v2.models

import androidx.annotation.DrawableRes
import com.example.ui_v2.R

internal data class CountryModelUI(
    val id: String = "",
    val country: String = "",
    val code: String = "",
    @DrawableRes
    val flag: Int = R.drawable.flag_default,
)