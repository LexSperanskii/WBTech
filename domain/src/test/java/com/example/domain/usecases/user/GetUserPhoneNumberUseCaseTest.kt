package com.example.domain.usecases.user

import com.example.domain.stabRepositories.UserRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

class GetUserPhoneNumberUseCaseTest {

    @Test
    fun `return correct user phone number`() = runTest{

        val testUserRepository = UserRepositoryStub()

        val useCase = GetUserPhoneNumberInteractor(userRepository = testUserRepository)

        val userPhoneNumber = useCase.execute().first()

        assertTrue(userPhoneNumber.number.isNotBlank() && userPhoneNumber.countryCode.isNotBlank())
    }

}