package com.github.yanadroidua.common.models

data class QuestionModel(
        val uuid: String,
        val userUuid: String,
        val answers: List<AnswerModel>,
        val rate: Int,
        val views: Long,
        val question: String,
        val archived: Boolean // read-only mode, no new comments
) {

    val isAnswered: Boolean
        get() = answers.any { it.solveIssue }

}