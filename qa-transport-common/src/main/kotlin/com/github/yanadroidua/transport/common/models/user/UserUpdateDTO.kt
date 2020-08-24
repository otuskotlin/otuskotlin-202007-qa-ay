package com.github.yanadroidua.transport.common.models.user

import kotlinx.serialization.Serializable

@Serializable
data class UserUpdateDTO(
        val uuid: String,
        val name: String? = null,
        val secondName: String? = null,
        val lastName: String? = null,
        val age: Int? = null,
        val points: Long? = null
)