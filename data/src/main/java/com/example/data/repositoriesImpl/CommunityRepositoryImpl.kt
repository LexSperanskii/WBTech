package com.example.data.repositoriesImpl

import com.example.domain.models.Community
import com.example.domain.models.CommunityDetail
import com.example.domain.models.MockData
import com.example.domain.repositories.ICommunityRepository

internal class CommunityRepositoryImpl(private val mock: MockData) : ICommunityRepository {
    override fun getListOfCommunities(): List<Community> {
        return mock.getListOfCommunities()
    }

    override fun getCommunityDetail(): CommunityDetail {
        return mock.getCommunity()
    }
}