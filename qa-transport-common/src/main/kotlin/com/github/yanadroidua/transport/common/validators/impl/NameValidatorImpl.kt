package com.github.yanadroidua.transport.common.validators.impl

import com.github.yanadroidua.transport.common.validators.NameValidator
import com.github.yanadroidua.transport.common.validators.base.ValidationResult

class NameValidatorImpl : NameValidator {

    private val nameRegExp = "^[a-zA-Z]+"

    override fun validate(model: String): ValidationResult {
        return if(nameRegExp.toRegex().matches(model)) {
            ValidationResult.valid()
        } else {
            ValidationResult.error(message = "Name should match $nameRegExp")
        }
    }
}