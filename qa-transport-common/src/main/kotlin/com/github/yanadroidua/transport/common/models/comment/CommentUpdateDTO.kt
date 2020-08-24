package com.github.yanadroidua.transport.common.models.comment

import kotlinx.serialization.Serializable

@Serializable
data class CommentUpdateDTO(
        val uuid: String,
        val comment: String? = null,
        val rate: Int? = null
)