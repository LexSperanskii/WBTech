package com.example.domain.usecases.user

import com.example.domain.stabRepositories.TestUserRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

class GetUserPhoneNumberUseCaseTest {

    @Test
    fun `return correct user phone number`() = runTest{

        val testUserRepository = TestUserRepository()

        val useCase = GetUserPhoneNumberInteractor(userRepository = testUserRepository)

        val userPhoneNumber = useCase.execute()

        assertNotNull(userPhoneNumber)
        assertTrue(userPhoneNumber.number.isNotEmpty())
        assertTrue(userPhoneNumber.number.isNotBlank())
        assertTrue(userPhoneNumber.countryCode.isNotEmpty())
        assertTrue(userPhoneNumber.countryCode.isNotBlank())
    }

}