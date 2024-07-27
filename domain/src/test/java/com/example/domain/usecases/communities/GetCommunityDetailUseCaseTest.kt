package com.example.domain.usecases.communities

import com.example.domain.stabRepositories.TestCommunityRepository
import com.example.domain.utils.COMMUNITY_ID
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class GetCommunityDetailUseCaseTest {

    @Test
    fun `return correct community`() = runTest{

        val testCommunityRepository = TestCommunityRepository()

        val useCase = GetCommunityDetailInteractor(communityRepository = testCommunityRepository)

        val communityDetail = useCase.execute(COMMUNITY_ID).first()

        assertNotNull(communityDetail)
        assertNotNull(communityDetail.id)
        assertNotNull(communityDetail.name)
        assertNotNull(communityDetail.description)
        assertNotNull(communityDetail.events)
        communityDetail.events.forEach { event ->
            assertNotNull(event.id)
            assertNotNull(event.name)
            assertNotNull(event.date)
            assertNotNull(event.city)
            assertNotNull(event.category)
            assertNotNull(event.isFinished)
        }
    }
}