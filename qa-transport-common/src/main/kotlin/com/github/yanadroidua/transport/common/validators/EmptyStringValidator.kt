package com.github.yanadroidua.transport.common.validators

import com.github.yanadroidua.transport.common.validators.base.ValidationResult
import com.github.yanadroidua.transport.common.validators.base.Validator

class EmptyStringValidator : Validator<String> {

    override fun validate(model: String): ValidationResult {
        return if (model.isBlank()) {
            ValidationResult.error("Empty string")
        } else {
            ValidationResult.valid()
        }
    }

}