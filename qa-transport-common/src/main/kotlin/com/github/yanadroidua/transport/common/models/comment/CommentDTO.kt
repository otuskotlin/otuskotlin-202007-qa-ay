package com.github.yanadroidua.transport.common.models.comment

import kotlinx.serialization.Serializable

@Serializable
data class CommentDTO(
        val uuid: String,
        val comment: String,
        val userUuid: String,
        val rate: Int
)