package com.github.yanadroidua.transport.common.validators.impl

import com.github.yanadroidua.transport.common.models.user.UserCreateDTO
import com.github.yanadroidua.transport.common.validators.AgeValidator
import com.github.yanadroidua.transport.common.validators.CreateUserValidator
import com.github.yanadroidua.transport.common.validators.NameValidator
import com.github.yanadroidua.transport.common.validators.base.ValidationResult
import java.lang.StringBuilder

class CreateUserValidatorImpl(
        private val nameValidator: NameValidator,
        private val ageValidator: AgeValidator
) : CreateUserValidator {
    override fun validate(model: UserCreateDTO): ValidationResult {
        val nameValidationResult = nameValidator.validate(model = model.name)
        val secondNameValidationResult = nameValidator.validate(model = model.secondName)
        val lastNameValidationResult = nameValidator.validate(model = model.lastName)
        val ageValidationResult = ageValidator.validate(model = model.age)

        return if (nameValidationResult.valid && secondNameValidationResult.valid
            && lastNameValidationResult.valid && ageValidationResult.valid
        ) {
            ValidationResult.valid()
        } else {
            val errorMessageBuilder = StringBuilder()
            if (!nameValidationResult.valid) {
                errorMessageBuilder.append("Field 'name': ${nameValidationResult.message}\n")
            }
            if (!secondNameValidationResult.valid) {
                errorMessageBuilder.append("Field 'secondName': ${secondNameValidationResult.message}\n")
            }
            if (!lastNameValidationResult.valid) {
                errorMessageBuilder.append("Field 'lastName': ${lastNameValidationResult.message}\n")
            }
            if (!ageValidationResult.valid) {
                errorMessageBuilder.append("Field 'age': ${ageValidationResult.message}")
            }
            ValidationResult.error(message = errorMessageBuilder.toString())
        }

    }
}