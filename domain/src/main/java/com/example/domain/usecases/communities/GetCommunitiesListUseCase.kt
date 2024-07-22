package com.example.domain.usecases.communities

import com.example.domain.models.Community
import com.example.domain.repositories.ICommunityRepository


interface GetCommunitiesListUseCase {
    fun execute(): List<Community>
}

internal class GetCommunitiesListInteractor(private val communityRepository: ICommunityRepository) :
    GetCommunitiesListUseCase {

    override fun execute(): List<Community> {
        return communityRepository.getListOfCommunities()
    }
}