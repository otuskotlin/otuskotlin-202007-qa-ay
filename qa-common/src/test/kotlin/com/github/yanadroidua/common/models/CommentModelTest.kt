package com.github.yanadroidua.common.models

import kotlin.test.Test
import kotlin.test.assertEquals

internal class CommentModelTest {

    private val testUuid: String = java.util.UUID.randomUUID().toString()
    private val testComment: String = "Test comment"
    private val testUserUuid: String = java.util.UUID.randomUUID().toString()
    private val testRate: Int = 123

    @Test
    fun creationTest() {
        val commentModel = CommentModel(
            testUuid,
            testComment,
            testUserUuid,
            testRate
        )

        assertEquals(testUuid, commentModel.uuid)
        assertEquals(testComment, commentModel.comment)
        assertEquals(testUserUuid, commentModel.userUuid)
        assertEquals(testRate, commentModel.rate)
    }

}