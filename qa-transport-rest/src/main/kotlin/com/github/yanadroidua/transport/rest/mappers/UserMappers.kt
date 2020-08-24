package com.github.yanadroidua.transport.rest.mappers

import com.github.yanadroidua.common.models.UserModel
import com.github.yanadroidua.transport.common.models.user.UserCreateDTO
import com.github.yanadroidua.transport.common.models.user.UserDTO
import com.github.yanadroidua.transport.common.models.user.UserUpdateDTO
import java.util.*

internal fun UserDTO.mapToUser() = UserModel(
    uuid = uuid,
    name = name,
    secondName = secondName,
    lastName = lastName,
    age = age,
    points = points
)

internal fun UserModel.mapToDTO() = UserDTO(
    uuid = uuid,
    name = name,
    secondName = secondName,
    lastName = lastName,
    age = age,
    points = points
)

internal fun UserCreateDTO.mapToUser() = UserModel(
    uuid = UUID.randomUUID().toString(),
    name = name,
    secondName = secondName,
    lastName = lastName,
    age = age,
    points = 0
)

internal fun UserUpdateDTO.mapToUser(originalUser: UserModel) = UserModel(
    uuid = uuid,
    name = name ?: originalUser.name,
    secondName = secondName ?: originalUser.secondName,
    lastName = lastName ?: originalUser.lastName,
    age = age ?: originalUser.age,
    points = points ?: originalUser.points
)