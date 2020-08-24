package com.github.yanadroidua.common.models

data class AnswerModel(
        val uuid: String,
        val answer: String,
        val comments: List<CommentModel>,
        val userUuid: String,
        val solveIssue: Boolean,
        val rate: Int
)