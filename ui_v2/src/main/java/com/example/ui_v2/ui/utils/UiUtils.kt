package com.example.ui_v2.ui.utils

internal enum class ButtonStatus {
    NotPressed,
    Loading,
    Pressed
}

internal object UiUtils {
    const val PHONE_NUMBER_LENGTH = 10
    const val SPLASH_SCREEN_DURATION = 1000L
    const val DEFAULT_DIVIDER = 100

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
    fun generateRandomWord(length: Int): String {
        val letters = ('a'..'z') + ('A'..'Z').toList()
        return (1..length)
            .map { letters.random() }
            .joinToString("")
    }
}
