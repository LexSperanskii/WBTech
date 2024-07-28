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
    private lateinit var useCase: GetCommunitiesListInteractor
    private lateinit var communities: List<Community>

    @Before
    fun setUp() = runTest {
        communityRepositoryStub = CommunityRepositoryStub()
        useCase = GetCommunitiesListInteractor(communityRepository = communityRepositoryStub)
        communities = useCase.execute().first()
    }

    @Test
    fun `communities id are unique`() {
        assertTrue(communities.distinctBy { it.id }.size == communities.size)
    }

    @Test
    fun `communities have not blank names`() {
        communities.forEach { community ->
            assertTrue(community.name.isNotBlank())
        }
    }
}