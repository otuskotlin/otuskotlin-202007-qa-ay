package com.github.yanadroidua.transport.rest.server.handlers

import com.github.yanadroidua.transport.common.models.ResponseModel
import com.github.yanadroidua.transport.common.models.ResponseStatus
import com.github.yanadroidua.transport.common.models.user.UserCreateDTO
import com.github.yanadroidua.transport.common.models.user.UserDTO
import com.github.yanadroidua.transport.common.validators.AgeValidator
import com.github.yanadroidua.transport.common.validators.NameValidator
import com.github.yanadroidua.transport.common.validators.user.UserValidator
import com.github.yanadroidua.transport.common.validators.UuidValidator
import com.github.yanadroidua.transport.common.validators.base.ValidationResult
import com.github.yanadroidua.transport.common.validators.user.CreateUserValidator
import com.github.yanadroidua.transport.rest.mappers.mapToDTO
import com.github.yanadroidua.transport.rest.mappers.mapToUser
import com.github.yanadroidua.transport.rest.utils.createRandomUser
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

internal class UserHandler(private val json: Json) {

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
            val validationResult = validateCreateUser(userDTO)
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

    //TODO: add Kodein for DI

    private fun validateCreateUser(createDTO: UserCreateDTO): ValidationResult {
        val nameValidator = NameValidator()
        val ageValidator = AgeValidator()
        return CreateUserValidator(nameValidator, ageValidator).validate(createDTO)
    }

    private fun validateUser(userDTO: UserDTO): ValidationResult {
        val nameValidator = NameValidator()
        val ageValidator = AgeValidator()
        val uuidValidator = UuidValidator()
        return UserValidator(uuidValidator, nameValidator, ageValidator).validate(userDTO)
    }

}