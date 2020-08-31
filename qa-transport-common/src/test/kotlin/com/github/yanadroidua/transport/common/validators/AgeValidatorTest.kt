package com.github.yanadroidua.transport.common.validators

import com.github.yanadroidua.transport.common.validators.impl.AgeValidatorImpl
import org.junit.Assert.*
import kotlin.test.Test

internal class AgeValidatorTest {

    private val ageValidator = AgeValidatorImpl()

    @Test
    fun testValidAges() {
        assertEquals(true, ageValidator.validate(20).valid)
        assertEquals(true, ageValidator.validate(100).valid)
    }

    @Test
    fun testNotValidAges() {
        assertEquals(false, ageValidator.validate(100500).valid)
        assertEquals(false, ageValidator.validate(-1).valid)
        assertEquals(false, ageValidator.validate(0).valid)
    }

}