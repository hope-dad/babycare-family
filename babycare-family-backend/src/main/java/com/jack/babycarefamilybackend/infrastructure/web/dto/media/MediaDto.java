package com.jack.babycarefamilybackend.infrastructure.web.dto.media;

import com.jack.babycarefamilybackend.domain.media.MediaStatus; // MediaStatus Enum 임포트
import com.jack.babycarefamilybackend.infrastructure.web.dto.user.UserDto; // UserDto 임포트 (업로드 유저 정보 DTO)

import java.time.LocalDateTime; // 또는 Instant 사용

public record MediaDto(
        Long id, // 미디어 ID
        String url, // 미디어 파일 URL
        MediaStatus type, // 미디어 타입 (Enum)
        String recordType, // 연결된 기록 타입
        Long recordId, // 연결된 기록의 ID

        Long uploadedById,
        String uploadedByUsername,
        UserDto uploadedBy, // UserDto 객체 자체를 포함

        LocalDateTime createdAt, // 생성 시간
        LocalDateTime updatedAt // 마지막 수정 시간

) {



}
