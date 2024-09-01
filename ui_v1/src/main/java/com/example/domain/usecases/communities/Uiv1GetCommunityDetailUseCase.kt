package com.example.domain.usecases.communities

import com.example.domain.models.Uiv1CommunityDetail
import com.example.domain.repositories.Uiv1ICommunityRepository
import kotlinx.coroutines.flow.Flow


internal interface Uiv1GetCommunityDetailUseCase {
    fun execute(communityId: Int): Flow<Uiv1CommunityDetail>
}

internal class Uiv1GetCommunityDetailUseCaseImpl(private val communityRepository: Uiv1ICommunityRepository) :
    Uiv1GetCommunityDetailUseCase {

    override fun execute(communityId: Int): Flow<Uiv1CommunityDetail> {
        return communityRepository.getCommunityDetail(communityId)
    }
}