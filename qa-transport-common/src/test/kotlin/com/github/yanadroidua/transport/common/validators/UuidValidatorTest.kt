package com.github.yanadroidua.transport.common.validators

import org.junit.Assert.*
import java.util.*
import kotlin.test.Test

internal class UuidValidatorTest {

    private val uuidValidator = UuidValidator()

    @Test
    fun `must be valid for real uuid`() {
        val uuid = UUID.randomUUID().toString()
        assertEquals(true, uuidValidator.validate(uuid).valid)
    }

    @Test
    fun `must fail for blank or wrong uuid formatted string`() {
        val shorterUuid = UUID.randomUUID().toString().substring(0, 2)
        val longerUuid = UUID.randomUUID().toString() + "TESTTESTTEST"
        assertEquals(false, uuidValidator.validate(shorterUuid).valid)
        assertEquals(false, uuidValidator.validate(longerUuid).valid)
        assertEquals(false, uuidValidator.validate("").valid)
    }

}