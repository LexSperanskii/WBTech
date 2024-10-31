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

    val listOfIconsMOCK = listOf(
        "https://i.pinimg.com/564x/dc/c4/ef/dcc4ef15c657260d1d13331daf3a13c8.jpg",
        "https://i.pinimg.com/564x/dc/c4/ef/dcc4ef15c657260d1d13331daf3a13c8.jpg",
        "https://i.pinimg.com/564x/dc/c4/ef/dcc4ef15c657260d1d13331daf3a13c8.jpg",
        "https://i.pinimg.com/736x/62/e5/50/62e550bc4e1bcc5bfd75b26127e63b6a.jpg",
        "https://i.pinimg.com/564x/f4/e0/c8/f4e0c8655494b4ed5fb490df336c5dcb.jpg",
        "https://i.pinimg.com/564x/25/b9/d5/25b9d5877b216b9edd7fbdd93955d968.jpg",
        "https://i.pinimg.com/564x/07/1e/f4/071ef43b8a3e3a3e32eba626da61faa9.jpg",
        "https://i.pinimg.com/736x/e5/3b/90/e53b900fe55028bd1305716aaac3602d.jpg",
        "https://i.pinimg.com/564x/e0/59/1d/e0591de77b707dbac61e29394b725ff4.jpg",
        "https://i.pinimg.com/564x/20/76/ca/2076ca961b890a0ad175b59fb37248c3.jpg",
        "https://i.pinimg.com/736x/8a/59/42/8a59429f123fe135e86fde71864b0921.jpg",
        "https://i.pinimg.com/736x/e9/fc/e3/e9fce3127136ff32d329ee248bebcf9f.jpg",
        "https://i.pinimg.com/736x/ee/92/9a/ee929a38297884933c3318ece374fd40.jpg",
        "https://i.pinimg.com/564x/47/3f/19/473f198dd6051ea58e7ef76e73b86800.jpg",
        "https://i.pinimg.com/564x/02/59/69/0259699a168aea21ba838cd4873a1fdc.jpg",
        "https://i.pinimg.com/564x/62/36/de/6236ded523155a85746a1121f5f04f1f.jpg",
        "https://i.pinimg.com/736x/fb/ed/18/fbed1849aa6fc35fb2e2ff6c595f4e78.jpg",
        "https://i.pinimg.com/564x/1d/7f/54/1d7f546625f4c22cede2d9958c02d2bc.jpg",
        "https://i.pinimg.com/736x/6a/3e/68/6a3e68e72301cb0927ab72d19caf74d1.jpg",
        "https://i.pinimg.com/564x/28/8c/d3/288cd3492dbf4c8e128c627d48970578.jpg",
        "https://i.pinimg.com/736x/c3/1e/4c/c31e4cc99059d690d6ce1f62f0227b71.jpg",
        "https://i.pinimg.com/736x/cb/02/a1/cb02a1f429e2ae046c5572cdbd5029ae.jpg",
        "https://i.pinimg.com/736x/fd/38/3a/fd383a2a477664d63fc726e25434fe0b.jpg",
        "https://i.pinimg.com/736x/55/6e/cc/556ecc1bf5f5a5b86e53cbd10a8b10ef.jpg",
        "https://i.pinimg.com/564x/3f/52/9a/3f529a11413837d20d1f436d53bf47c6.jpg",
        "https://i.pinimg.com/564x/54/7f/5c/547f5cfc0eadbaf8b455901000cf045d.jpg",
        "https://i.pinimg.com/564x/79/a6/d2/79a6d27000d0f0a834a0ead3edca44fe.jpg",
        "https://i.pinimg.com/736x/6c/7b/91/6c7b9184c6397bc2efd2fd34b4724833.jpg",
        "https://i.pinimg.com/564x/84/c6/c4/84c6c435ec75543c6be459e5db12c274.jpg",
        "https://i.pinimg.com/564x/b2/69/ba/b269ba2d674ae968063be32bc1c8af2a.jpg",
        "https://i.pinimg.com/736x/3a/11/01/3a110130f3311e6a62eca8617111b426.jpg",
        "https://i.pinimg.com/564x/ae/bc/35/aebc359faab886d0081e5dba46b4a998.jpg",
    )

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
