package com.github.yanadroidua.transport.common.di

import com.github.yanadroidua.transport.common.validators.*
import com.github.yanadroidua.transport.common.validators.impl.*
import com.github.yanadroidua.transport.common.validators.impl.AgeValidatorImpl
import com.github.yanadroidua.transport.common.validators.impl.EmptyStringValidatorImpl
import com.github.yanadroidua.transport.common.validators.impl.UserValidatorImpl
import com.github.yanadroidua.transport.common.validators.impl.UuidValidatorImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

const val TRANSPORT_COMMON_MODULE = "transport-common-module"

val transportCommonModule = DI.Module(name = TRANSPORT_COMMON_MODULE) {
    bind<EmptyStringValidator>() with singleton { EmptyStringValidatorImpl() }
    bind<UuidValidator>() with singleton { UuidValidatorImpl() }
    bind<AgeValidator>() with singleton { AgeValidatorImpl() }
    bind<NameValidator>() with singleton { NameValidatorImpl() }
    bind<UserValidator>() with singleton { UserValidatorImpl(instance(), instance(), instance()) }
    bind<CreateUserValidator>() with singleton { CreateUserValidatorImpl(instance(), instance()) }
}
