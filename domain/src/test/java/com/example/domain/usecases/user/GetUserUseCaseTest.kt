package com.example.domain.usecases.user

import com.example.domain.stabRepositories.UserRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

class GetUserUseCaseTest {

    @Test
    fun `return correct user name`() = runTest{

        val testUserRepository = UserRepositoryStub()

        val useCase = GetUserInteractor(userRepository = testUserRepository)

        val user = useCase.execute().first()

        assertTrue(user.name.isNotBlank())
    }

    @Test
    fun `return correct user phone number`() = runTest{

        val testUserRepository = UserRepositoryStub()

        val useCase = GetUserInteractor(userRepository = testUserRepository)

        val user = useCase.execute().first()

        assertTrue(user.phoneNumber.number.isNotBlank() && user.phoneNumber.countryCode.isNotBlank())
    }
}