package com.github.yanadroidua.transport.rest.utils

import com.github.yanadroidua.transport.common.models.user.UserDTO
import java.lang.StringBuilder
import java.util.*
import kotlin.random.Random

fun createRandomUser(): UserDTO {
    val random = Random(seed = System.currentTimeMillis())
    return UserDTO(
        uuid = UUID.randomUUID().toString(),
        name = createRandomString(random, 10),
        lastName = createRandomString(random, 15),
        secondName = createRandomString(random, 12),
        age = random.nextInt(),
        points = random.nextLong()
    )
}

fun createRandomString(random: Random, maxLength: Int): String {
    val nameLength = random.nextInt(from = 1, until = maxLength + 1)
    val name = StringBuilder()
    repeat(nameLength) {
        name.append(random.nextInt(from = Char.MIN_VALUE.toInt(), until = Char.MAX_VALUE.toInt() + 1).toChar())
    }
    return name.toString()
}