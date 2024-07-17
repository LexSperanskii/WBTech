package com.example.spa_wb_junior_devmeetingapp.ui.utils

import com.example.spa_wb_junior_devmeetingapp.model.PhoneNumber


object UiUtils {
    const val PHONE_NUMBER_LENGTH = 10

    private const val ONE_CHAR_LENGTH = 1
    private const val FIRST_SPACE_POSITION = 3
    private const val FIRST_DASH_POSITION = 6
    private const val SECOND_DASH_POSITION = 8

    fun formattedMobileNumber(mobileNumber: PhoneNumber): String {
        return when (mobileNumber.number.length) {
            PHONE_NUMBER_LENGTH -> buildString {
                append(mobileNumber.countryCode)
                append(" ")
                append(mobileNumber.number.substring(0, FIRST_SPACE_POSITION))
                append(" ")
                append(mobileNumber.number.substring(FIRST_SPACE_POSITION, FIRST_DASH_POSITION))
                append("-")
                append(mobileNumber.number.substring(FIRST_DASH_POSITION, SECOND_DASH_POSITION))
                append("-")
                append(mobileNumber.number.substring(SECOND_DASH_POSITION))
            }
            else -> buildString {
                append(mobileNumber.countryCode)
                append(" ")
                append(mobileNumber.number)
            }
        }
    }

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
}
