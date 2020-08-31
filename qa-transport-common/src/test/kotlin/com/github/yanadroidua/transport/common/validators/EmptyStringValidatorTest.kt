package com.github.yanadroidua.transport.common.validators

import com.github.yanadroidua.transport.common.validators.impl.EmptyStringValidatorImpl
import kotlin.test.Test
import kotlin.test.assertEquals

internal class EmptyStringValidatorTest {

    private val validator = EmptyStringValidatorImpl()

    @Test
    fun `empty string should not pass validation`() {
        assertEquals(false, validator.validate("").valid)
        assertEquals(false, validator.validate("      ").valid)
        assertEquals(false, validator.validate("\t").valid)
        assertEquals(false, validator.validate("\n").valid)
    }

    @Test
    fun `not empty string should pass validation`() {
        assertEquals(true, validator.validate("I'm not empty").valid)
    }

}