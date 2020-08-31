package com.github.yanadroidua.transport.rest.server.routing

import com.github.yanadroidua.transport.rest.server.Constants
import com.github.yanadroidua.transport.rest.server.handlers.UserHandler
import io.ktor.routing.*
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.ktor.di
import org.kodein.di.ktor.subDI
import org.kodein.di.singleton

internal fun Route.userRouting() {
    subDI {
        bind<UserHandler>() with singleton { UserHandler(instance(), instance(), instance()) }
    }
    get (path = Constants.Routing.RANDOM_USER) {
        val userHandler: UserHandler by di().instance()
        userHandler.getRandomUser(this)
    }
    post (path = Constants.Routing.CREATE_USER) {
        val userHandler: UserHandler by di().instance()
        userHandler.handlePostUser(this)
    }
}