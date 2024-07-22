package com.example.domain.model

data class CommunityDetail(
    val id : Int,
    val name : String,
    val description : String,
    val events: List<Event>
)