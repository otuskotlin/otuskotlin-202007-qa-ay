package com.github.yanadroidua.transport.common.models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseModel<T>(
    val status: ResponseStatus,
    val data: T
)