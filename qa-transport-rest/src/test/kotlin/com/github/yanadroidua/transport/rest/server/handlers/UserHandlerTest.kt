package com.github.yanadroidua.transport.rest.server.handlers

import com.github.yanadroidua.transport.common.validators.impl.*
import com.github.yanadroidua.transport.rest.server.Constants
import io.ktor.http.*
import io.ktor.server.testing.*
import io.ktor.test.dispatcher.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlin.test.Test

internal class UserHandlerTest {

    private val json: Json = Json { allowStructuredMapKeys = true }

    private val userHandler = UserHandler(
            json,
            CreateUserValidatorImpl(NameValidatorImpl(), AgeValidatorImpl()),
            UserValidatorImpl(UuidValidatorImpl(), NameValidatorImpl(), AgeValidatorImpl())
    )
    //TODO: add tests

    @Test
    fun `getRandomUser should give valid user`() = withTestApplication {
//        with(handleRequest(HttpMethod.Get, Constants.Routing.RANDOM_USER)) {
//            val randomUser = userHandler.getRandomUser(response.pipeline)
//
//        }
        //TODO: add Ktor test
    }


}