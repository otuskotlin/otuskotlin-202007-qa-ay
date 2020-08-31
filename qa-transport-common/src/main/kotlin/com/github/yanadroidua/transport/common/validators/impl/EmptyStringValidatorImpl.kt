package com.github.yanadroidua.transport.common.validators.impl

import com.github.yanadroidua.transport.common.validators.EmptyStringValidator
import com.github.yanadroidua.transport.common.validators.base.ValidationResult

class EmptyStringValidatorImpl : EmptyStringValidator {

    override fun validate(model: String): ValidationResult {
        return if (model.isBlank()) {
            ValidationResult.error("Empty string")
        } else {
            ValidationResult.valid()
        }
    }

}