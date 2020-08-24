package com.github.yanadroidua.transport.common.models.question

import kotlinx.serialization.Serializable

@Serializable
data class QuestionUpdateDTO(
        val uuid: String,
        val question: String? = null,
        val archived: Boolean? = null,
        val rate: Int? = null,
        val views: Long? = null
)