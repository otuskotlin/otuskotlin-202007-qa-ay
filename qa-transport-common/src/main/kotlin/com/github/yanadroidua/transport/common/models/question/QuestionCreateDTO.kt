package com.github.yanadroidua.transport.common.models.question

import kotlinx.serialization.Serializable

@Serializable
data class QuestionCreateDTO(
        val userUuid: String,
        val question: String
)