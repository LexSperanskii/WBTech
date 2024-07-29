package com.example.domain.usecases.user

import com.example.domain.models.PhoneNumber
import com.example.domain.stabRepositories.UserRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue

class GetUserPhoneNumberUseCaseTest {

    private lateinit var testUserRepository: UserRepositoryStub
    private lateinit var useCase: GetUserPhoneNumberUseCaseImpl
    private lateinit var userPhoneNumber: PhoneNumber

    @Before
    fun setUp() = runTest {
        testUserRepository = UserRepositoryStub()
        useCase = GetUserPhoneNumberUseCaseImpl(userRepository = testUserRepository)
        userPhoneNumber = useCase.execute().first()
    }

    @Test
    fun `user phone number country code is not blank`() {
        assertTrue(userPhoneNumber.countryCode.isNotBlank())
    }

    @Test
    fun `user phone number is not blank`() {
        assertTrue(userPhoneNumber.number.isNotBlank())

    }
}