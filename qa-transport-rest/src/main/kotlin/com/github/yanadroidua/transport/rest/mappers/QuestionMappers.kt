package com.github.yanadroidua.transport.rest.mappers

import com.github.yanadroidua.common.models.QuestionModel
import com.github.yanadroidua.transport.common.models.question.QuestionCreateDTO
import com.github.yanadroidua.transport.common.models.question.QuestionDTO
import com.github.yanadroidua.transport.common.models.question.QuestionUpdateDTO
import java.util.*

internal fun QuestionCreateDTO.mapToQuestion() = QuestionModel(
    uuid = UUID.randomUUID().toString(),
    userUuid = userUuid,
    answers = emptyList(),
    rate = 0,
    views = 0L,
    question = question,
    archived = false
)

internal fun QuestionUpdateDTO.mapToQuestion(originalQuestion: QuestionModel) = QuestionModel(
    uuid = uuid,
    userUuid = originalQuestion.userUuid,
    answers = originalQuestion.answers,
    rate = rate ?: originalQuestion.rate,
    views = views ?: originalQuestion.views,
    question = question ?: originalQuestion.question,
    archived = archived ?: originalQuestion.archived
)

internal fun QuestionDTO.mapToQuestion() = QuestionModel(
    uuid = uuid,
    userUuid = userUuid,
    answers = answers.map { it.mapToAnswer() },
    rate = rate,
    views = views,
    question = question,
    archived = archived
)

internal fun QuestionModel.mapToDTO() = QuestionDTO(
    uuid = uuid,
    userUuid = userUuid,
    answers = answers.map { it.mapToDTO() },
    rate = rate,
    views = views,
    question = question,
    archived = archived
)