package com.example.domain.usecases.user

import com.example.domain.stabRepositories.UserRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue

class GetUserUseCaseTest {

    private lateinit var testUserRepository: UserRepositoryStub
    private lateinit var useCase: GetUserUseCaseImpl
    private lateinit var user: User

    @Before
    fun setUp() {
        testUserRepository = UserRepositoryStub()
        useCase = GetUserUseCaseImpl(userRepository = testUserRepository)
    }

    @Test
    fun `user name is not blank`() = runTest {
        user = useCase.execute().first()
        val result = user.name

        assertTrue(result.isNotBlank())
    }

    @Test
    fun `user phone number country code is not blank`() = runTest {
        user = useCase.execute().first()
        val result = user.phoneNumber.countryCode

        assertTrue(result.isNotBlank())
    }

    @Test
    fun `user phone number is not blank`() = runTest {
        user = useCase.execute().first()
        val result = user.phoneNumber.number

        assertTrue(result.isNotBlank())
    }
}