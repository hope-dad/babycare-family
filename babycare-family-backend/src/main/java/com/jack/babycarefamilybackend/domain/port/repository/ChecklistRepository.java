package com.jack.babycarefamilybackend.domain.port.repository;

import com.jack.babycarefamilybackend.domain.checklist.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    // 기본 조회
    List<Checklist> findByBabyId(Long babyId);
    List<Checklist> findByUserId(Long userId);

    // 완료 상태별 조회
    List<Checklist> findByBabyIdAndCompleted(Long babyId, boolean completed);
    List<Checklist> findByUserIdAndCompleted(Long userId, boolean completed);

    // 마감일 관련 조회
    List<Checklist> findByBabyIdAndDueDateLessThanEqualAndCompletedFalse(Long babyId, LocalDate dueDate);
    List<Checklist> findByBabyIdAndDueDate(Long babyId, LocalDate dueDate);

    // 카테고리 및 우선순위 관련 조회
    List<Checklist> findByBabyIdAndCategoryOrderByPriorityDesc(Long babyId, String category);

    // 추가적인 조회 메서드
    List<Checklist> findByBabyIdAndDueDateBetween(Long babyId, LocalDate startDate, LocalDate endDate);
    List<Checklist> findByBabyIdAndCompletedOrderByPriorityDesc(Long babyId, boolean completed);

}
