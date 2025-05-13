package com.jack.babycarefamilybackend.domain.port.repository;

import com.jack.babycarefamilybackend.domain.commant.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRecordTypeAndRecordId(String recordType, Long recordId);
    List<Comment> findByBabyId(Long babyId);
}
