package com.github.yanadroidua.transport.common.validators.user

import com.github.yanadroidua.transport.common.models.user.UserCreateDTO
import com.github.yanadroidua.transport.common.models.user.UserDTO
import com.github.yanadroidua.transport.common.validators.AgeValidator
import com.github.yanadroidua.transport.common.validators.NameValidator
import com.github.yanadroidua.transport.common.validators.UuidValidator
import com.github.yanadroidua.transport.common.validators.base.ValidationResult
import com.github.yanadroidua.transport.common.validators.base.Validator
import java.lang.StringBuilder

class CreateUserValidator(
    private val nameValidator: NameValidator,
    private val ageValidator: AgeValidator
) : Validator<UserCreateDTO> {
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