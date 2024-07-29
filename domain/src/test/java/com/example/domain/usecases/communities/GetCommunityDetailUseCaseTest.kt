package com.example.domain.usecases.communities

import com.example.domain.models.CommunityDetail
import com.example.domain.stabRepositories.CommunityRepositoryStub
import com.example.domain.utils.COMMUNITY_ID
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class GetCommunityDetailUseCaseTest {

    private lateinit var communityRepositoryStub: CommunityRepositoryStub
    private lateinit var useCase: GetCommunityDetailUseCaseImpl
    private lateinit var communityDetail: CommunityDetail

    @Before
    fun setUp() = runTest {
        communityRepositoryStub = CommunityRepositoryStub()
        useCase = GetCommunityDetailUseCaseImpl(communityRepository = communityRepositoryStub)
        communityDetail = useCase.execute(COMMUNITY_ID).first()
    }

    @Test
    fun `received correct community by id`() {
        assertEquals(communityDetail.id, COMMUNITY_ID)
    }

    @Test
    fun `community have not blank name`() {
        Assert.assertTrue(communityDetail.name.isNotBlank())
    }
}