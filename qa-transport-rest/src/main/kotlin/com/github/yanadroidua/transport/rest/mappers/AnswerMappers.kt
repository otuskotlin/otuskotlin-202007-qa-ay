package com.github.yanadroidua.transport.rest.mappers

import com.github.yanadroidua.common.models.AnswerModel
import com.github.yanadroidua.transport.common.models.answer.AnswerCreateDTO
import com.github.yanadroidua.transport.common.models.answer.AnswerDTO
import com.github.yanadroidua.transport.common.models.answer.AnswerUpdateDTO
import java.util.*

internal fun AnswerDTO.mapToAnswer() = AnswerModel(
    uuid = uuid,
    answer = answer,
    userUuid = userUuid,
    comments = comments.map { it.mapToComment() },
    solveIssue = solveIssue,
    rate = rate
)

internal fun AnswerCreateDTO.mapToAnswers() = AnswerModel(
    uuid = UUID.randomUUID().toString(),
    answer = comment,
    userUuid = userUuid,
    solveIssue = false,
    comments = emptyList(),
    rate = 0
)

internal fun AnswerUpdateDTO.mapToAnswers(original: AnswerModel) = AnswerModel(
    uuid = uuid,
    answer = comment ?: original.answer,
    userUuid = original.userUuid,
    solveIssue = solveIssue ?: original.solveIssue,
    rate = rate ?: original.rate,
    comments = original.comments
)

internal fun AnswerModel.mapToDTO() = AnswerDTO(
    uuid = uuid,
    answer = answer,
    userUuid = userUuid,
    solveIssue = solveIssue,
    comments = comments.map { it.mapToDTO() },
    rate = rate
)