package com.github.yanadroidua.transport.common.validators.user

import com.github.yanadroidua.transport.common.models.user.UserDTO
import com.github.yanadroidua.transport.common.validators.AgeValidator
import com.github.yanadroidua.transport.common.validators.NameValidator
import com.github.yanadroidua.transport.common.validators.UserValidator
import com.github.yanadroidua.transport.common.validators.UuidValidator
import com.github.yanadroidua.transport.common.validators.base.ValidationResult
import com.github.yanadroidua.transport.common.validators.impl.*
import org.junit.Assert
import org.junit.Test
import java.util.*

internal class UserValidatorTest {

    private val userDTO = UserDTO(
        uuid = UUID.randomUUID().toString(),
        name = "Andrii",
        secondName = "Yan",
        lastName = "Serg",
        age = 20,
        points = 0
    )

    private val userValidator = UserValidatorImpl(
        nameValidator = NameValidatorImpl(),
        ageValidator = AgeValidatorImpl(),
        uuidValidator = UuidValidatorImpl()
    )

    @Test
    fun `should pass for valid user`() {
        Assert.assertEquals(true, userValidator.validate(userDTO).valid)
    }

    @Test
    fun `should fail for wrong age`() {
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(age = 100500)).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(age = 0)).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(age = -10)).valid)
    }

    @Test
    fun `should fail for wrong name`() {
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(name = "123")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(name = "Andy123")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(name = "")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(name = "\t")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(name = "\b")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(name = " ")).valid)
    }

    @Test
    fun `should fail for wrong secondName`() {
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(secondName = "123")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(secondName = "Andy123")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(secondName = "")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(secondName = "\t")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(secondName = "\b")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(secondName = " ")).valid)
    }

    @Test
    fun `should fail for wrong lastName`() {
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(lastName = "123")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(lastName = "Andy123")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(lastName = "")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(lastName = "\t")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(lastName = "\b")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(lastName = " ")).valid)
    }

    @Test
    fun `should fail for wring uuid`() {
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(uuid = "123")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(uuid = "Andy123")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(uuid = "")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(uuid = "\t")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(uuid = "\b")).valid)
        Assert.assertEquals(false, userValidator.validate(userDTO.copy(uuid = " ")).valid)
    }

    @Test
    fun `should fail if name validation fails`() {
        val errorMessage = "My Mock"
        val mUserValidatorImpl = UserValidatorImpl(
            ageValidator = AgeValidatorImpl(),
            nameValidator = object : NameValidator {
                override fun validate(model: String): ValidationResult {
                    return ValidationResult.error(errorMessage)
                }
            },
            uuidValidator = UuidValidatorImpl()
        )

        val validationResult = mUserValidatorImpl.validate(userDTO)
        Assert.assertEquals(false, validationResult.valid)
        Assert.assertEquals(true, validationResult.message.contains(errorMessage))
    }

    @Test
    fun `should fail if age validation fails`() {
        val errorMessage = "My Mock"
        val mUserValidatorImpl = UserValidatorImpl(
            nameValidator = NameValidatorImpl(),
            ageValidator = object : AgeValidator {
                override fun validate(model: Int): ValidationResult {
                    return ValidationResult.error(errorMessage)
                }
            },
            uuidValidator = UuidValidatorImpl()
        )

        val validationResult = mUserValidatorImpl.validate(userDTO)
        Assert.assertEquals(false, validationResult.valid)
        Assert.assertEquals(true, validationResult.message.contains(errorMessage))
    }

    @Test
    fun `should fail if uuid validation fails`() {
        val errorMessage = "My Mock"
        val mUserValidatorImpl = UserValidatorImpl(
            nameValidator = NameValidatorImpl(),
            uuidValidator = object : UuidValidator {
                override fun validate(model: String): ValidationResult {
                    return ValidationResult.error(errorMessage)
                }
            },
            ageValidator = AgeValidatorImpl()
        )

        val validationResult = mUserValidatorImpl.validate(userDTO)
        Assert.assertEquals(false, validationResult.valid)
        Assert.assertEquals(true, validationResult.message.contains(errorMessage))
    }

}