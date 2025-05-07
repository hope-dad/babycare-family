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
    private final BabyRecordRepository babyRecordRepository;

    public Comment toEntity(CreateCommentRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + request.userId()));

        BabyRecord record = babyRecordRepository.findById(request.babyRecordId())
                .orElseThrow(() -> new IllegalArgumentException("BabyRecord not found with id: " + request.babyRecordId()));

        return new Comment(request.text(), record, user);
    }

    public CommentDto toDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getText(),
                comment.getBabyRecord().getId(),
                comment.getUser().getId()
        );
    }
}
