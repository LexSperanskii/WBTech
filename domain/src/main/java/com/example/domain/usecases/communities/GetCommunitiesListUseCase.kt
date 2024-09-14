package com.example.domain.usecases.communities

import com.example.domain.repositories.networkRepository.ICommunityRepository
import kotlinx.coroutines.flow.Flow


interface GetCommunitiesListUseCase {
    fun execute(): Flow<List<Community>>
}

internal class GetCommunitiesListUseCaseImpl(private val communityRepository: ICommunityRepository) :
    GetCommunitiesListUseCase {

    override fun execute(): Flow<List<Community>> {
        return communityRepository.getListOfCommunities()
    }
}