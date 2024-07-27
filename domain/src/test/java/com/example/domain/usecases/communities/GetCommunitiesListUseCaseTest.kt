package com.example.domain.usecases.communities

import com.example.domain.stabRepositories.TestCommunityRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull


class GetCommunitiesListUseCaseTest {

    @Test
    fun `return correct communities list`() = runTest{

        val testCommunityRepository = TestCommunityRepository()

        val useCase = GetCommunitiesListInteractor(communityRepository = testCommunityRepository)

        val communities = useCase.execute().first()

        assertNotNull(communities)
        communities.forEach { community ->
            assertNotNull(community.id)
            assertNotNull(community.name)
            assertTrue(community.size >= 0)
        }
    }
}