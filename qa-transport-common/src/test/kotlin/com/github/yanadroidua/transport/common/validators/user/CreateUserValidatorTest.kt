package com.github.yanadroidua.transport.common.validators.user

import com.github.yanadroidua.transport.common.models.user.UserCreateDTO
import com.github.yanadroidua.transport.common.validators.AgeValidator
import com.github.yanadroidua.transport.common.validators.NameValidator
import com.github.yanadroidua.transport.common.validators.base.ValidationResult
import com.github.yanadroidua.transport.common.validators.impl.*
import org.junit.Assert.assertEquals
import kotlin.test.Test

internal class CreateUserValidatorTest {

    private val createUserDTO = UserCreateDTO(
        name = "Andrii",
        secondName = "Yan",
        lastName = "Serg",
        age = 20
    )

    private val userValidator = CreateUserValidatorImpl(
        nameValidator = NameValidatorImpl(),
        ageValidator = AgeValidatorImpl()
    )

    @Test
    fun `should pass for valid user`() {
        assertEquals(true, userValidator.validate(createUserDTO).valid)
    }

    @Test
    fun `should fail for wrong age`() {
        assertEquals(false, userValidator.validate(createUserDTO.copy(age = 100500)).valid)
    }

    @Test
    fun `should fail for wrong name`() {
        assertEquals(false, userValidator.validate(createUserDTO.copy(name = "123")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(name = "Andy123")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(name = "")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(name = "\t")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(name = "\b")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(name = " ")).valid)
    }

    @Test
    fun `should fail for wrong secondName`() {
        assertEquals(false, userValidator.validate(createUserDTO.copy(secondName = "123")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(secondName = "Andy123")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(secondName = "")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(secondName = "\t")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(secondName = "\b")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(secondName = " ")).valid)
    }

    @Test
    fun `should fail for wrong lastName`() {
        assertEquals(false, userValidator.validate(createUserDTO.copy(lastName = "123")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(lastName = "Andy123")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(lastName = "")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(lastName = "\t")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(lastName = "\b")).valid)
        assertEquals(false, userValidator.validate(createUserDTO.copy(lastName = " ")).valid)
    }

    @Test
    fun `should fail if name validation fails`() {
        val errorMessage = "My Mock"
        val mUserValidatorImpl = CreateUserValidatorImpl(
            ageValidator = AgeValidatorImpl(),
            nameValidator = object : NameValidator {
                override fun validate(model: String): ValidationResult {
                    return ValidationResult.error(errorMessage)
                }
            }
        )

        val validationResult = mUserValidatorImpl.validate(createUserDTO)
        assertEquals(false, validationResult.valid)
        assertEquals(true, validationResult.message.contains(errorMessage))
    }

    @Test
    fun `should fail if age validation fails`() {
        val errorMessage = "My Mock"
        val mUserValidatorImpl = CreateUserValidatorImpl(
            nameValidator = NameValidatorImpl(),
            ageValidator = object : AgeValidator {
                override fun validate(model: Int): ValidationResult {
                    return ValidationResult.error(errorMessage)
                }
            }
        )

        val validationResult = mUserValidatorImpl.validate(createUserDTO)
        assertEquals(false, validationResult.valid)
        assertEquals(true, validationResult.message.contains(errorMessage))
    }

}