package com.example.domain.models

internal data class Uiv1User(
    val id: Int,
    val name: String,
    val surname: String,
    val uiv1PhoneNumber: Uiv1PhoneNumber,
    val iconURL: String?,
)