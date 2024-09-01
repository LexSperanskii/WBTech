package com.example.ui_v1.models

internal data class UIv1EventModelUI(
    val id: Int = 0,
    val name: String = "",
    val date: String = "",
    val city: String = "",
    val category: List<String> = listOf(),
    val iconURL: String = "",
    val isFinished: Boolean = false,
)