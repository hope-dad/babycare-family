package com.jack.babycarefamilybackend.application.comment;

import com.jack.babycarefamilybackend.domain.commant.Comment;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.comment.CommentDto;
import com.jack.babycarefamilybackend.dto.comment.CreateCommentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "user", source = "user")
    Comment toEntity(CreateCommentRequest request, User user);

    @Mapping(source = "user.id", target = "userId")
    CommentDto toDto(Comment comment);
}