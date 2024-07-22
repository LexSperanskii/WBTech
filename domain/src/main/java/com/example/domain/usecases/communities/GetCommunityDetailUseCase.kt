package com.example.domain.usecases.communities

import com.example.domain.models.CommunityDetail
import com.example.domain.repositories.ICommunityRepository


interface GetCommunityDetailUseCase {
    fun execute(): CommunityDetail
}

internal class GetCommunityDetailInteractor(private val communityRepository: ICommunityRepository) :
    GetCommunityDetailUseCase {

    override fun execute(): CommunityDetail {
        return communityRepository.getCommunityDetail()
    }
}