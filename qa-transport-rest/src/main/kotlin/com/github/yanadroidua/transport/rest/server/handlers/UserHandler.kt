package com.github.yanadroidua.transport.rest.server.handlers

import com.github.yanadroidua.transport.common.models.ResponseModel
import com.github.yanadroidua.transport.common.models.ResponseStatus
import com.github.yanadroidua.transport.common.models.user.UserCreateDTO
import com.github.yanadroidua.transport.common.models.user.UserDTO
import com.github.yanadroidua.transport.common.validators.CreateUserValidator
import com.github.yanadroidua.transport.common.validators.UserValidator
import com.github.yanadroidua.transport.rest.mappers.mapToDTO
import com.github.yanadroidua.transport.rest.mappers.mapToUser
import com.github.yanadroidua.transport.rest.utils.createRandomUser
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

internal class UserHandler(
    private val json: Json,
    private val createUserValidator: CreateUserValidator,
    private val userValidator: UserValidator
) {

    suspend fun getRandomUser(request: PipelineContext<Unit, ApplicationCall>) {
        return request.call.respond(
            json.encodeToString(ResponseModel.serializer(UserDTO.serializer()), ResponseModel(
                status = ResponseStatus.SUCCESS,
                data = createRandomUser()
            ))
        )
    }

    suspend fun handlePostUser(request: PipelineContext<Unit, ApplicationCall>) {
        try {
            val userDTO = request.call.receive(UserCreateDTO::class)
            val validationResult = createUserValidator.validate(userDTO)
            if (validationResult.valid) {
                val userModel = userDTO.mapToUser()
                //TODO: save to database
                request.call.respond(
                    json.encodeToJsonElement(ResponseModel.serializer(UserDTO.serializer()), ResponseModel(
                        status = ResponseStatus.SUCCESS,
                        data = userModel.mapToDTO()
                    ))
                )
            } else {
                request.call.respond(
                    json.encodeToJsonElement(ResponseModel.serializer(String.serializer()), ResponseModel(
                        status = ResponseStatus.ERROR,
                        data = validationResult.message
                    ))
                )
            }
        } catch (e: Exception) {
            //TODO: put error to log file
            e.printStackTrace()
            request.call.respond(
                json.encodeToJsonElement(ResponseModel.serializer(String.serializer()), ResponseModel(
                    status = ResponseStatus.ERROR,
                    data = e.message ?: "Error happened"
                ))
            )
        }
    }

}