package com.example.domain.usecases.user

import com.example.domain.models.User
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
    fun setUp() = runTest {
        testUserRepository = UserRepositoryStub()
        useCase = GetUserUseCaseImpl(userRepository = testUserRepository)
        user = useCase.execute().first()
    }

    @Test
    fun `user name is not blank`() {
        assertTrue(user.name.isNotBlank())
    }

    @Test
    fun `user phone number country code is not blank`() {
        assertTrue(user.phoneNumber.countryCode.isNotBlank())

    }

    @Test
    fun `user phone number is not blank`() {
        assertTrue(user.phoneNumber.number.isNotBlank())

    }
}