package com.example.domain.usecases.communities

import com.example.domain.models.Uiv1Community
import com.example.domain.repositories.Uiv1ICommunityRepository
import kotlinx.coroutines.flow.Flow


internal interface Uiv1GetCommunitiesListUseCase {
    fun execute(): Flow<List<Uiv1Community>>
}

internal class Uiv1GetCommunitiesListUseCaseImpl(private val communityRepository: Uiv1ICommunityRepository) :
    Uiv1GetCommunitiesListUseCase {

    override fun execute(): Flow<List<Uiv1Community>> {
        return communityRepository.getListOfCommunities()
    }
}