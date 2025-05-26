package com.jack.babycarefamilybackend.infrastructure.web.dto.media;

import com.jack.babycarefamilybackend.domain.media.MediaStatus; // MediaStatus Enum 임포트
import jakarta.validation.constraints.NotBlank; // @NotBlank 임포트
import jakarta.validation.constraints.NotNull; // @NotNull 임포트

public record CreateMediaRequest(
        @NotBlank(message = "미디어 URL은 필수입니다.")
        String url,

        @NotNull(message = "미디어 타입은 필수입니다.")
        MediaStatus type,

        @NotBlank(message = "연결될 기록 타입은 필수입니다.")
        String recordType,

        @NotNull(message = "연결될 기록 ID는 필수입니다.")
        Long recordId,

        @NotNull(message = "업로드한 유저 ID는 필수입니다.")
        Long uploadedById, // 요청에 포함시키는 경우

        // 선택 사항 필드
        String fileName,
        Long fileSize
) {
}
