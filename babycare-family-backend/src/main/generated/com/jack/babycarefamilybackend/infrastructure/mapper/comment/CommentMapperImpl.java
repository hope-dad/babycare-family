package com.jack.babycarefamilybackend.infrastructure.mapper.comment;

import com.jack.babycarefamilybackend.domain.commant.Comment;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.comment.CommentDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-23T09:41:44+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDto toDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        Long userId = null;
        Long id = null;
        String content = null;
        String recordType = null;
        Long recordId = null;
        Long babyId = null;
        LocalDateTime createdAt = null;

        userId = commentUserId( comment );
        id = comment.getId();
        content = comment.getContent();
        recordType = comment.getRecordType();
        recordId = comment.getRecordId();
        babyId = comment.getBabyId();
        createdAt = comment.getCreatedAt();

        CommentDto commentDto = new CommentDto( id, content, recordType, recordId, babyId, userId, createdAt );

        return commentDto;
    }

    private Long commentUserId(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        User user = comment.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
