package com.example.domain.usecases.communities

import com.example.domain.models.Community
import com.example.domain.repositories.ICommunityRepository
import kotlinx.coroutines.flow.Flow


interface GetCommunitiesListUseCase {
    fun execute(): Flow<List<Community>>
}

internal class GetCommunitiesListInteractor(private val communityRepository: ICommunityRepository) :
    GetCommunitiesListUseCase {

    override fun execute(): Flow<List<Community>> {
        return communityRepository.getListOfCommunities()
    }
}