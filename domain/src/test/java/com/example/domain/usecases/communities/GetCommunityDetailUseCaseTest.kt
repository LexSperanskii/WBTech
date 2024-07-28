package com.example.domain.usecases.communities

import com.example.domain.stabRepositories.CommunityRepositoryStub
import com.example.domain.utils.COMMUNITY_ID
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

class GetCommunityDetailUseCaseTest {

    @Test
    fun `return correct community`() = runTest{

        val communityRepositoryStub = CommunityRepositoryStub()

        val useCase = GetCommunityDetailInteractor(communityRepository = communityRepositoryStub)

        val communityDetail = useCase.execute(COMMUNITY_ID).first()

        assertEquals(communityDetail.id, COMMUNITY_ID)
    }
}