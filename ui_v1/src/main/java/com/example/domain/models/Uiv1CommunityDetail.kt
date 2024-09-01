package com.example.domain.models

internal data class Uiv1CommunityDetail(
    val id: Int,
    val name: String,
    val description: String,
    val uiv1Events: List<Uiv1Event>,
)