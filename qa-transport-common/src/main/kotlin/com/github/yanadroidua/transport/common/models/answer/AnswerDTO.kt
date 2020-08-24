package com.github.yanadroidua.transport.common.models.answer

import com.github.yanadroidua.transport.common.models.comment.CommentDTO
import kotlinx.serialization.Serializable

@Serializable
data class AnswerDTO(
        val uuid: String,
        val answer: String,
        val comments: List<CommentDTO>,
        val userUuid: String,
        val solveIssue: Boolean,
        val rate: Int
)