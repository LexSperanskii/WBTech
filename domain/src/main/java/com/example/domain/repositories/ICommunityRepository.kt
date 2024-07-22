package com.example.domain.repositories

import com.example.domain.models.Community
import com.example.domain.models.CommunityDetail

interface ICommunityRepository {
    fun getListOfCommunities(): List<Community>
    fun getCommunityDetail(): CommunityDetail
}