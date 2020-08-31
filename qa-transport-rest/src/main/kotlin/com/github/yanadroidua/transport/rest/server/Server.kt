package com.github.yanadroidua.transport.rest.server

import com.github.yanadroidua.transport.common.di.transportCommonModule
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
import org.kodein.di.ktor.di
import org.kodein.di.singleton

fun main(args: Array<String>) {

    val server = embeddedServer(Netty, port = 8080) {
        di {
            import(module = transportCommonModule)
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