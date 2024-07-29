package com.example.domain.usecases.communities

import com.example.domain.models.Community
import com.example.domain.stabRepositories.CommunityRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test


class GetCommunitiesListUseCaseTest {

    private lateinit var communityRepositoryStub: CommunityRepositoryStub
    private lateinit var useCase: GetCommunitiesListUseCaseImpl
    private lateinit var communities: List<Community>

    @Before
    fun setUp() {
        communityRepositoryStub = CommunityRepositoryStub()
        useCase = GetCommunitiesListUseCaseImpl(communityRepository = communityRepositoryStub)
    }

    @Test
    fun `communities id are unique`() = runTest {
        communities = useCase.execute().first()
        val result = communities.distinctBy { it.id }.size
        val expectedResult = communities.size

        assertTrue(result == expectedResult)
    }

    @Test
    fun `communities have not blank names`() = runTest {
        communities = useCase.execute().first()
        communities.forEach { community ->
            val result = community.name

            assertTrue(result.isNotBlank())
        }
    }
}