package com.github.yanadroidua.transport.common.models.user

import kotlinx.serialization.Serializable

@Serializable
data class UserCreateDTO(
        val name: String,
        val secondName: String,
        val lastName: String,
        val age: Int
)