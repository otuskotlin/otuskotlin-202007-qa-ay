package com.github.yanadroidua.transport.rest.mappers

import com.github.yanadroidua.common.models.CommentModel
import com.github.yanadroidua.transport.common.models.comment.CommentCreateDTO
import com.github.yanadroidua.transport.common.models.comment.CommentDTO
import com.github.yanadroidua.transport.common.models.comment.CommentUpdateDTO
import java.util.*

internal fun CommentCreateDTO.mapToComment() = CommentModel(
    uuid = UUID.randomUUID().toString(),
    comment = comment,
    userUuid = userUuid,
    rate = 0
)

internal fun CommentUpdateDTO.mapToComment(original: CommentModel) = CommentModel(
    uuid = uuid,
    comment = comment ?: original.comment,
    userUuid = original.userUuid,
    rate = rate ?: original.rate
)

internal fun CommentDTO.mapToComment() = CommentModel(
    uuid = uuid,
    comment = comment ,
    userUuid = userUuid,
    rate = rate
)

internal fun CommentModel.mapToDTO() = CommentDTO(
    uuid = uuid,
    comment = comment ,
    userUuid = userUuid,
    rate = rate
)