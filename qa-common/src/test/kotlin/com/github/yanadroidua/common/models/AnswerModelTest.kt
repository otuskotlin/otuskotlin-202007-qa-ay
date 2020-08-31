package com.github.yanadroidua.common.models

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class AnswerModelTest {

    private val testUuid: String = UUID.randomUUID().toString()
    private val testAnswer: String = "Test answer"
    private val comments: List<CommentModel> = emptyList()
    private val testUserUuid: String = UUID.randomUUID().toString()
    private val testSolveIssue: Boolean = false
    private val testRate: Int = 123

    @Test
    fun testCreation() {
        val answerModel = AnswerModel(
            testUuid,
            testAnswer,
            comments,
            testUserUuid,
            testSolveIssue,
            testRate
        )

        assertEquals(testUuid, answerModel.uuid)
        assertEquals(testAnswer, answerModel.answer)
        assertEquals(comments, answerModel.comments)
        assertEquals(testUserUuid, answerModel.userUuid)
        assertEquals(testSolveIssue, answerModel.solveIssue)
        assertEquals(testRate, answerModel.rate)

    }

}