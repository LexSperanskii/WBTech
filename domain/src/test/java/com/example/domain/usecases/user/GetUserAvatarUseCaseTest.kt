package com.example.domain.usecases.user

import com.example.domain.stabRepositories.UserRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

class GetUserAvatarUseCaseTest {

    @Test
    fun `return correct user avatar`() = runTest{

        val testUserRepository = UserRepositoryStub()

        val useCase = GetUserAvatarInteractor(userRepository = testUserRepository)

        val userAvatar = useCase.execute().first()

        assertTrue(userAvatar.isNotBlank())
    }
}