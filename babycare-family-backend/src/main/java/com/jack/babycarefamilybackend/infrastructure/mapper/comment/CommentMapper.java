package com.jack.babycarefamilybackend.infrastructure.mapper.comment;

import com.jack.babycarefamilybackend.domain.commant.Comment;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.comment.CommentDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.comment.CreateCommentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    default Comment toEntity(CreateCommentRequest request, User user) {
        return new Comment(
                request.content(),
                request.recordType(),
                request.recordId(),
                request.babyId(),
                user,
                null
        );
    }

    @Mappings({
            @Mapping(target = "userId", source = "comment.user.id")
    })
    CommentDto toDto(Comment comment);
}