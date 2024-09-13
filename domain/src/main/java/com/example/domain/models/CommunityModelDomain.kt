package com.example.domain.models

data class CommunityModelDomain(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val imageURL: String = "",
)

data class CommunitiesAdvertBlockModelDomain(
    val id: String = "",
    val nameOfBlock: String = "",
    val listOfCommunities: List<CommunityModelDomain> = listOf(),
)