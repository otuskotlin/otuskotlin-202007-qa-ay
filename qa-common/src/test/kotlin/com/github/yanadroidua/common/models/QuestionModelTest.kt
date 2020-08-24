package com.github.yanadroidua.common.models

import org.junit.Before
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

internal class QuestionModelTest {

    private val randomUuid = UUID.randomUUID().toString()
    private val userRandomUuid = UUID.randomUUID().toString()
    private val answers: List<AnswerModel> = emptyList()
    private val rate = 100500
    private val views = 2123321213L
    private val archived = true
    private val question = "asdasd"

    lateinit var testQuestionModel: QuestionModel

    @Before
    fun createTestModel() {
        testQuestionModel = QuestionModel(
                userUuid = userRandomUuid,
                archived = archived,
                answers = answers,
                uuid = randomUuid,
                rate = rate,
                views = views,
                question = question
        )
    }

    @Test
    fun testQuestionCreation() {
        assertEquals(userRandomUuid, testQuestionModel.userUuid)
        assertEquals(archived, testQuestionModel.archived)
        assertEquals(answers, testQuestionModel.answers)
        assertEquals(randomUuid, testQuestionModel.uuid)
        assertEquals(rate, testQuestionModel.rate)
        assertEquals(views, testQuestionModel.views)
        assertEquals(question, testQuestionModel.question)
    }

    @Test
    fun testIfCommentsEmptyAndQuestionIsNotSolved() {
        assertEquals(false, testQuestionModel.isAnswered)
    }

    @Test
    fun testIfCommentsHasNoSolvedAndQuestionInNotSolved() {
        val questionModel = testQuestionModel.copy(answers = listOf(
                AnswerModel(
                        uuid = UUID.randomUUID().toString(),
                        answer = "This is dummy, test comment!",
                        userUuid = UUID.randomUUID().toString(),
                        solveIssue = false,
                        rate = 100
                )
        ))
        assertEquals(false, questionModel.isAnswered)
    }

    @Test
    fun testIfCommentsHasSolvedAndQuestionIsSolved() {
        val questionModel = testQuestionModel.copy(answers = listOf(
                AnswerModel(
                        uuid = UUID.randomUUID().toString(),
                        answer = "This is dummy, test comment!",
                        userUuid = UUID.randomUUID().toString(),
                        solveIssue = true,
                        rate = 100
                )
        ))
        assertEquals(true, questionModel.isAnswered)
    }

}