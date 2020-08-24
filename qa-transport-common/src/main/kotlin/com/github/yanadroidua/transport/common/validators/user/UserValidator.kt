package com.github.yanadroidua.transport.common.validators.user

import com.github.yanadroidua.transport.common.models.user.UserDTO
import com.github.yanadroidua.transport.common.validators.AgeValidator
import com.github.yanadroidua.transport.common.validators.NameValidator
import com.github.yanadroidua.transport.common.validators.UuidValidator
import com.github.yanadroidua.transport.common.validators.base.ValidationResult
import com.github.yanadroidua.transport.common.validators.base.Validator
import java.lang.StringBuilder

class UserValidator(
    private val uuidValidator: UuidValidator,
    private val nameValidator: NameValidator,
    private val ageValidator: AgeValidator
) : Validator<UserDTO> {
    override fun validate(model: UserDTO): ValidationResult {
        val uuidValidationResult = uuidValidator.validate(model = model.uuid)
        val nameValidationResult = nameValidator.validate(model = model.name)
        val secondNameValidationResult = nameValidator.validate(model = model.secondName)
        val lastNameValidationResult = nameValidator.validate(model = model.lastName)
        val ageValidationResult = ageValidator.validate(model = model.age)

        return if (uuidValidationResult.valid && nameValidationResult.valid && secondNameValidationResult.valid
            && lastNameValidationResult.valid && ageValidationResult.valid) {
            ValidationResult.valid()
        } else {
            val errorMessageBuilder = StringBuilder()
            if (!uuidValidationResult.valid) {
                errorMessageBuilder.append("Field 'uuid': ${uuidValidationResult.message}")
                errorMessageBuilder.append("\n")
            }
            if (!nameValidationResult.valid) {
                errorMessageBuilder.append("Field 'name': ${nameValidationResult.message}")
                errorMessageBuilder.append("\n")
            }
            if (!secondNameValidationResult.valid) {
                errorMessageBuilder.append("Field 'secondName': ${secondNameValidationResult.message}")
                errorMessageBuilder.append("\n")
            }
            if (!lastNameValidationResult.valid) {
                errorMessageBuilder.append("Field 'lastName': ${lastNameValidationResult.message}")
                errorMessageBuilder.append("\n")
            }
            if (!ageValidationResult.valid) {
                errorMessageBuilder.append("Field 'age': ${ageValidationResult.message}")
            }
            ValidationResult.error(message = errorMessageBuilder.toString())
        }

    }
}