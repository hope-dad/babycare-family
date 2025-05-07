package com.jack.babycarefamilybackend.application.comment;

import com.jack.babycarefamilybackend.domain.record.BabyRecord;
import com.jack.babycarefamilybackend.domain.record.repository.BabyRecordRepository;
import com.jack.babycarefamilybackend.domain.commant.Comment;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.comment.CommentDto;
import com.jack.babycarefamilybackend.dto.comment.CreateCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentMapper {

    private final UserRepository userRepository;

    public Comment toEntity(CreateCommentRequest request, User user) {

        return new Comment(
                request.content(),
                request.recordType(),
                request.recordId(),
                request.babyId(),
                user
        );
    }

    public CommentDto toDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getContent(),
                comment.getRecordType(),
                comment.getRecordId(),
                comment.getBabyId(),
                comment.getUser().getId(),
                comment.getCreatedAt()
        );
    }
}