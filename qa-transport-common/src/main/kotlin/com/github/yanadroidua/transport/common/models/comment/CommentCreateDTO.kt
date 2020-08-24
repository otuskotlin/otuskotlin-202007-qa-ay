package com.github.yanadroidua.transport.common.models.comment

import kotlinx.serialization.Serializable

@Serializable
data class CommentCreateDTO(
        val comment: String,
        val userUuid: String,
        val answerUuid: String
)