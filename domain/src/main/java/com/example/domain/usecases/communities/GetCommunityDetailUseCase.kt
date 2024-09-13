package com.example.domain.usecases.communities

import com.example.domain.repositories.ICommunityRepository
import kotlinx.coroutines.flow.Flow


interface GetCommunityDetailUseCase {
    fun execute(communityId: Int): Flow<CommunityDetail>
}

internal class GetCommunityDetailUseCaseImpl(private val communityRepository: ICommunityRepository) :
    GetCommunityDetailUseCase {

    override fun execute(communityId: Int): Flow<CommunityDetail> {
        return communityRepository.getCommunityDetail(communityId)
    }
}