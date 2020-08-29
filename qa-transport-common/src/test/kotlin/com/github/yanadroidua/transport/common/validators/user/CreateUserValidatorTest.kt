package com.github.yanadroidua.transport.common.validators.user

import com.github.yanadroidua.transport.common.models.user.UserCreateDTO
import com.github.yanadroidua.transport.common.validators.AgeValidator
import com.github.yanadroidua.transport.common.validators.NameValidator
import org.junit.Assert.assertEquals
import kotlin.test.Test

internal class CreateUserValidatorTest {

    private val createUserDTO = UserCreateDTO(
        name = "Andrii",
        secondName = "Yan",
        lastName = "Serg",
        age = 20
    )

    private val userValidator = CreateUserValidator(
        nameValidator = NameValidator(),
        ageValidator = AgeValidator()
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

}