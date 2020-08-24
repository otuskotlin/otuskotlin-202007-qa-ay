package com.github.yanadroidua.transport.common.models.question

import com.github.yanadroidua.transport.common.models.answer.AnswerDTO
import kotlinx.serialization.Serializable

@Serializable
data class QuestionDTO(
        val uuid: String,
        val userUuid: String,
        val answers: List<AnswerDTO>,
        val question: String,
        val rate: Int,
        val views: Long,
        val archived: Boolean // read-only mode, no new comments
) {

    val isAnswered: Boolean
        get() = answers.any { it.solveIssue }

}