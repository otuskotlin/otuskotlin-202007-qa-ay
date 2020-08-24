package com.github.yanadroidua.transport.rest.server

import com.github.yanadroidua.transport.rest.server.routing.user
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.json.Json

private val json: Json by lazy { Json { allowStructuredMapKeys = true } }

fun main(args: Array<String>) {

    val server = embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json(contentType = ContentType.Application.Json)
        }
        routing {
            get(path = Constants.Routing.ROOT) {
                call.respondText("Hello World", ContentType.Text.Plain)
            }
            user(json = json)
        }
    }
    server.start(wait = true)
}