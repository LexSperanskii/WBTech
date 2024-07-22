package com.example.domain.model

data class Event(
    val id: Int,
    val name: String,
    val date: String,
    val city: String,
    val category: List<String>,
    val iconURL: String,
    val isFinished: Boolean
)