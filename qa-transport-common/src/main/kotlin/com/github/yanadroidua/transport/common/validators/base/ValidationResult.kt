package com.github.yanadroidua.transport.common.validators.base

class ValidationResult private constructor(
    val valid: Boolean,
    val message: String
) {

    companion object {

        fun valid() = ValidationResult(valid = true, message = "Ok")

        fun error(message: String) = ValidationResult(valid = false, message = message)

    }

}