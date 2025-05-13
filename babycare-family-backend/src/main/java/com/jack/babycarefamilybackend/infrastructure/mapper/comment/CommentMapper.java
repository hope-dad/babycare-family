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
                null // createdAt은 엔티티 내부나 DB에서 설정될 거라 null 또는 기본값 전달
        );
    }

    // Comment 엔티티를 받아서 CommentDto로 변환
    @Mappings({
            @Mapping(target = "userId", source = "comment.user.id")
    })
    CommentDto toDto(Comment comment);
}