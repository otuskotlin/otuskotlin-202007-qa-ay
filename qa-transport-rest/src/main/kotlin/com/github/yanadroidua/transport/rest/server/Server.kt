package com.github.yanadroidua.transport.rest.server

import com.github.yanadroidua.transport.common.validators.AgeValidator
import com.github.yanadroidua.transport.common.validators.EmptyStringValidator
import com.github.yanadroidua.transport.common.validators.NameValidator
import com.github.yanadroidua.transport.common.validators.UuidValidator
import com.github.yanadroidua.transport.common.validators.user.CreateUserValidator
import com.github.yanadroidua.transport.rest.server.routing.userRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.json.Json
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.ktor.di
import org.kodein.di.singleton

fun main(args: Array<String>) {

    val server = embeddedServer(Netty, port = 8080) {
        di {
            bind<EmptyStringValidator>() with singleton { EmptyStringValidator() }
            bind<NameValidator>() with singleton { NameValidator() }
            bind<AgeValidator>() with singleton { AgeValidator() }
            bind<UuidValidator>() with singleton { UuidValidator() }
            bind<CreateUserValidator>() with singleton { CreateUserValidator(instance(), instance()) }
            bind<Json>() with singleton { Json { allowStructuredMapKeys = true } }
        }
        install(ContentNegotiation) {
            json(contentType = ContentType.Application.Json)
        }
        routing {
            get(path = Constants.Routing.ROOT) {
                call.respondText("Hello World", ContentType.Text.Plain)
            }
            userRouting()
        }
    }
    server.start(wait = true)
}