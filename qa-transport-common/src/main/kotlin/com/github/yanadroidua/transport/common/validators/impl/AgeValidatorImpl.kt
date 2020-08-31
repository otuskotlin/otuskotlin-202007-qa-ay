package com.github.yanadroidua.transport.common.validators.impl

import com.github.yanadroidua.transport.common.validators.AgeValidator
import com.github.yanadroidua.transport.common.validators.base.ValidationResult

class AgeValidatorImpl : AgeValidator {
    override fun validate(model: Int): ValidationResult {
        return if (model in 1 .. 150) {
            ValidationResult.valid()
        } else {
            ValidationResult.error(message = "Wrong age!")
        }
    }
}