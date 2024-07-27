package com.example.domain.usecases.user

import com.example.domain.stabRepositories.TestUserRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

class GetUserUseCaseTest {

    @Test
    fun `return correct user`() = runTest{

        val testUserRepository = TestUserRepository()

        val useCase = GetUserInteractor(userRepository = testUserRepository)

        val user = useCase.execute().first()

        assertNotNull(user)
        assertNotNull(user.id)
        assertNotNull(user.name)
        assertNotNull(user.surname)
        assertNotNull(user.phoneNumber)
        assertTrue(user.phoneNumber.number.isNotEmpty())
        assertTrue(user.phoneNumber.number.isNotBlank())
        assertTrue(user.phoneNumber.countryCode.isNotEmpty())
        assertTrue(user.phoneNumber.countryCode.isNotBlank())
    }
}