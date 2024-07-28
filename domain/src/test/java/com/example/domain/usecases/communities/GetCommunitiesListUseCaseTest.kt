package com.example.domain.usecases.communities

import com.example.domain.stabRepositories.CommunityRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull


class GetCommunitiesListUseCaseTest {

    @Test
    fun `return correct communities list`() = runTest{

        val communityRepositoryStub = CommunityRepositoryStub()

        val useCase = GetCommunitiesListInteractor(communityRepository = communityRepositoryStub)

        val communities = useCase.execute().first()

        assertTrue(communities.distinctBy { it.id }.size == communities.size) // проверяем уникальность id
    }
}