package com.github.yanadroidua.transport.common.validators.impl

import com.github.yanadroidua.transport.common.validators.UuidValidator
import com.github.yanadroidua.transport.common.validators.base.ValidationResult

class UuidValidatorImpl : UuidValidator {

    override fun validate(model: String): ValidationResult {
        return if (model.isBlank() || model.length != 36) {
            return ValidationResult.error("Wrong length, must equal 36, but got ${model.length}")
        } else {
            ValidationResult.valid()
        }
    }

}