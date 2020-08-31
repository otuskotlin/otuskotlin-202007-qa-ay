package com.github.yanadroidua.transport.common.validators

import com.github.yanadroidua.transport.common.validators.impl.NameValidatorImpl
import org.junit.Assert.*
import kotlin.test.Test

internal class NameValidatorTest {

    private val nameValidator = NameValidatorImpl()

    @Test
    fun testValidNames() {
        val name1 = "Andrii"
        val name2 = "Bohdan"

        assertEquals(true, nameValidator.validate(name1).valid)
        assertEquals(true, nameValidator.validate(name2).valid)
    }

    @Test
    fun testNotValidNames() {
        val name1 = "123321"
        val name2 = "+-./,"
        val name3 = "Andy100500"

        assertEquals(false, nameValidator.validate(name1).valid)
        assertEquals(false, nameValidator.validate(name2).valid)
        assertEquals(false, nameValidator.validate(name3).valid)
        assertEquals(false, nameValidator.validate("").valid)
        assertEquals(false, nameValidator.validate(" ").valid)
        assertEquals(false, nameValidator.validate("\n").valid)
        assertEquals(false, nameValidator.validate("\t").valid)
    }

}