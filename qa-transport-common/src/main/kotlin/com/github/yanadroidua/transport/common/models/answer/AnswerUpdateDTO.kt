package com.github.yanadroidua.transport.common.models.answer

import kotlinx.serialization.Serializable

@Serializable
data class AnswerUpdateDTO(
        val uuid: String,
        val comment: String? = null,
        val solveIssue: Boolean? = null,
        val rate: Int? = null
)