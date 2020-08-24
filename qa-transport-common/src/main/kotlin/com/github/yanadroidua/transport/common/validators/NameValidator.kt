package com.github.yanadroidua.transport.common.validators

import com.github.yanadroidua.transport.common.validators.base.ValidationResult
import com.github.yanadroidua.transport.common.validators.base.Validator

class NameValidator : Validator<String> {

    private val nameRegExp = "^[a-zA-Z]+"

    override fun validate(model: String): ValidationResult {
        return if(nameRegExp.toRegex().matches(model)) {
            ValidationResult.valid()
        } else {
            ValidationResult.error(message = "Name should match $nameRegExp")
        }
    }
}