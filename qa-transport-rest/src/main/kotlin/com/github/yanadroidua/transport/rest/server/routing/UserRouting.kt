package com.github.yanadroidua.transport.rest.server.routing

import com.github.yanadroidua.transport.rest.server.Constants
import com.github.yanadroidua.transport.rest.server.handlers.UserHandler
import io.ktor.routing.*
import kotlinx.serialization.json.Json

private var userHandler: UserHandler? = null

private fun userHandler(json: Json): UserHandler {
    if (userHandler == null) {
        userHandler = UserHandler(json)
    }
    return userHandler!!
}

internal fun Route.user(json: Json) {
    get (path = Constants.Routing.RANDOM_USER) { userHandler(json).getRandomUser(this) }
    post (path = Constants.Routing.CREATE_USER) { userHandler(json).handlePostUser(this) }
}