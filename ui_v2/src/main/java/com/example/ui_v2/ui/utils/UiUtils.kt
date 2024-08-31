package com.example.ui_v2.ui.utils

internal enum class ButtonStatus {
    Active,
    Loading,
    Pressed,
    Disabled
}

internal object UiUtils {
    const val PHONE_NUMBER_LENGTH = 10
    const val SPLASH_SCREEN_DURATION = 1000L
    const val DEFAULT_DIVIDER = 100
    const val DEFAULT_OVERLAPPING_PERCENTAGE = 0.20f
    const val DEFAULT_OVERLAPPING_PEOPLE_COUNT = 5
    const val DEFAULT_ID = "0"

    private const val ONE_CHAR_LENGTH = 1

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
