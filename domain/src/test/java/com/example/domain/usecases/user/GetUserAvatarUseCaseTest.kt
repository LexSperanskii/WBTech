package com.example.domain.usecases.user

import com.example.domain.stabRepositories.UserRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue

class GetUserAvatarUseCaseTest {

    private lateinit var testUserRepository: UserRepositoryStub
    private lateinit var useCase: GetUserAvatarUseCaseImpl
    private lateinit var userAvatar: String

    @Before
    fun setUp() = runTest {
        testUserRepository = UserRepositoryStub()
        useCase = GetUserAvatarUseCaseImpl(userRepository = testUserRepository)
        userAvatar = useCase.execute().first()
    }

    @Test
    fun `user avatar is not blank`() {
        assertTrue(userAvatar.isNotBlank())
    }

    @Test
    fun `user avatar is not empty`() {
        assertTrue(userAvatar.isNotEmpty())
    }
}