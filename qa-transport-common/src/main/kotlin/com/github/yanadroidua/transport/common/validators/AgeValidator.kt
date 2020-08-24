package com.github.yanadroidua.transport.common.validators

import com.github.yanadroidua.transport.common.validators.base.ValidationResult
import com.github.yanadroidua.transport.common.validators.base.Validator

class AgeValidator : Validator<Int> {
    override fun validate(model: Int): ValidationResult {
        return if (model in 1 .. 150) {
            ValidationResult.valid()
        } else {
            ValidationResult.error(message = "Wrong age!")
        }
    }
}