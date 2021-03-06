package com.github.yanadroidua.transport.common.validators

import com.github.yanadroidua.transport.common.validators.base.ValidationResult
import com.github.yanadroidua.transport.common.validators.base.Validator

class UuidValidator : Validator<String> {

    override fun validate(model: String): ValidationResult {
        return if (model.isBlank() || model.length < 256) {
            return ValidationResult.error("Wrong length, must equal 256, but got ${model.length}")
        } else {
            ValidationResult.valid()
        }
    }

}