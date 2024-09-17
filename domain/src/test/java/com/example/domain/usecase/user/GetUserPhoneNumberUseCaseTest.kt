package com.example.domain.usecase.user

//import com.example.domain.stabRepositories.UserRepositoryStub
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.test.runTest
//import org.junit.Before
//import org.junit.Test
//import org.junit.jupiter.api.Assertions.assertTrue
//
//class GetUserPhoneNumberUseCaseTest {
//
//    private lateinit var testUserRepository: UserRepositoryStub
//    private lateinit var useCase: GetUserPhoneNumberUseCaseImpl
//    private lateinit var userPhoneNumber: PhoneNumber
//
//    @Before
//    fun setUp() {
//        testUserRepository = UserRepositoryStub()
//        useCase = GetUserPhoneNumberUseCaseImpl(userRepository = testUserRepository)
//    }
//
//    @Test
//    fun `user phone number country code is not blank`() = runTest {
//        userPhoneNumber = useCase.execute().first()
//        val result = userPhoneNumber.countryCode
//
//        assertTrue(result.isNotBlank())
//    }
//
//    @Test
//    fun `user phone number is not blank`() = runTest {
//        userPhoneNumber = useCase.execute().first()
//        val result = userPhoneNumber.number
//
//        assertTrue(result.isNotBlank())
//    }
//}