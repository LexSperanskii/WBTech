package com.example.domain.models

data class PhoneNumberModelDomain(
    val country: CountryModelDomain = CountryModelDomain(),
    val number: String = "",
)