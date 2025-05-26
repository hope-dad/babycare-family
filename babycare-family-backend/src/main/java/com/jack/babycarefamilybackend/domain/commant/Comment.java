package com.jack.babycarefamilybackend.domain.commant;

import com.jack.babycarefamilybackend.domain.common.BaseTimeEntity;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String recordType;
    private Long recordId;
    private Long babyId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Comment(String content, String recordType, Long recordId, Long babyId, User user, LocalDateTime createdAt) {
        this.content = content;
        this.recordType = recordType;
        this.recordId = recordId;
        this.babyId = babyId;
        this.user = user;
    }
    public static Comment create(String content, String recordType, Long recordId, Long babyId, User user) {
        Comment comment = new Comment();
        comment.content = content;
        comment.recordType = recordType;
        comment.recordId = recordId;
        comment.babyId = babyId;
        comment.user = user;
        return comment;
    }
}
