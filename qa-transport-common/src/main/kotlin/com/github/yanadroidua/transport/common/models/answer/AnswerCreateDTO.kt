package com.github.yanadroidua.transport.common.models.answer

import kotlinx.serialization.Serializable

@Serializable
data class AnswerCreateDTO(
        val comment: String,
        val userUuid: String,
        val questionUuid: String
)