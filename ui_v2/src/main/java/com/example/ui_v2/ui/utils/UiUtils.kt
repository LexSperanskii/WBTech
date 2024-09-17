package com.example.ui_v2.ui.utils

import com.example.ui_v2.models.PhoneNumberModelUI

internal enum class ButtonStatus {
    Active,
    Loading,
    Pressed
}

internal object UiUtils {
    const val PHONE_NUMBER_LENGTH = 10
    const val PIN_CODE_LENGTH = 4
    const val SPLASH_SCREEN_DURATION = 1000L
    const val DEFAULT_DIVIDER = 100
    const val DEFAULT_OVERLAPPING_PERCENTAGE = 0.20f
    const val DEFAULT_OVERLAPPING_PEOPLE_COUNT = 5
    const val DEFAULT_ID = "0"

    private const val ONE_CHAR_LENGTH = 1
    private const val FIRST_SPACE_POSITION = 3
    private const val FIRST_DASH_POSITION = 6
    private const val SECOND_DASH_POSITION = 8

    fun replaceFirstCharToCapitalCase(text: String): String {
        return when {
            text.length == ONE_CHAR_LENGTH -> {
                text.replaceFirstChar { it.titlecaseChar() }
            }

            else -> {
                text
            }
        }
    }

    fun formattedMobileNumber(phoneNumber: PhoneNumberModelUI): String {
        return when (phoneNumber.number.length) {
            PHONE_NUMBER_LENGTH -> buildString {
                append(phoneNumber.country.code)
                append(" ")
                append(phoneNumber.number.substring(0, FIRST_SPACE_POSITION))
                append(" ")
                append(phoneNumber.number.substring(FIRST_SPACE_POSITION, FIRST_DASH_POSITION))
                append("-")
                append(phoneNumber.number.substring(FIRST_DASH_POSITION, SECOND_DASH_POSITION))
                append("-")
                append(phoneNumber.number.substring(SECOND_DASH_POSITION))
            }

            else -> buildString {
                append(phoneNumber.country)
                append(" ")
                append(phoneNumber.number)
            }
        }
    }

}
