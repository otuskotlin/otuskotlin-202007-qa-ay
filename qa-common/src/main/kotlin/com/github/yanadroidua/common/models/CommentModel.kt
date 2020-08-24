package com.github.yanadroidua.common.models

data class CommentModel(
        val uuid: String,
        val comment: String,
        val userUuid: String,
        val rate: Int
)