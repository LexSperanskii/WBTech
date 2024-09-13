package com.example.domain.usecases.communities

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
    fun setUp() {
        communityRepositoryStub = CommunityRepositoryStub()
        useCase = GetCommunityDetailUseCaseImpl(communityRepository = communityRepositoryStub)
    }

    @Test
    fun `received correct community by id`() = runTest {
        communityDetail = useCase.execute(COMMUNITY_ID).first()
        val result = communityDetail.id
        val expectedResult = COMMUNITY_ID

        assertEquals(result, expectedResult)
    }

    @Test
    fun `community have not blank name`() = runTest {
        communityDetail = useCase.execute(COMMUNITY_ID).first()
        val result = communityDetail.name

        Assert.assertTrue(result.isNotBlank())
    }
}