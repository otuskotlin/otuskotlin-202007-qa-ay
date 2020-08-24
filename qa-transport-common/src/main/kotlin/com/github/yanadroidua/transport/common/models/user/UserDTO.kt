package com.github.yanadroidua.transport.common.models.user

import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
        val uuid: String,
        val name: String,
        val secondName: String,
        val lastName: String,
        val age: Int,
        val points: Long
)