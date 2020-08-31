package com.github.yanadroidua.common.models

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class UserModelTest {

    private val testRandomUuid: String = UUID.randomUUID().toString()
    private val testName: String = "Test name"
    private val testSecondName: String = "Test second name"
    private val testLastName: String = "Test last name"
    private val testAge: Int = 123
    private val testPoints: Long = 51984

    @Test
    fun creationTest() {
        val user = UserModel(
            testRandomUuid,
            testName,
            testSecondName,
            testLastName,
            testAge,
            testPoints
        )

        assertEquals(testRandomUuid, user.uuid)
        assertEquals(testName, user.name)
        assertEquals(testSecondName, user.secondName)
        assertEquals(testLastName, user.lastName)
        assertEquals(testAge, user.age)
        assertEquals(testPoints, user.points)

    }

}