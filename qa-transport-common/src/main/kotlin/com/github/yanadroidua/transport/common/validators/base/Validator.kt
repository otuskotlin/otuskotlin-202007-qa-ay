package com.github.yanadroidua.transport.common.validators.base

interface Validator<T> {

    /**
     * @return null if validation is Success and message if validation is not successful
     */
    fun validate(model: T): ValidationResult

}