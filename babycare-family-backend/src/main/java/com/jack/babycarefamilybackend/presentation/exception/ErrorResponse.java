package com.jack.babycarefamilybackend.presentation.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Builder
public class ErrorResponse {


    private final LocalDateTime timestamp; // 에러 발생 시간
    private final int status; // HTTP 상태 코드
    private final String error; // HTTP Status Reason (예: Bad Request, Internal Server Error)
    private final String code; // 네 커스텀 에러 코드
    private final String message; // 에러 상세 메시지
    private final String path; // 요청 경로
    private final String userMessage; // 사용자에게 보여줄 친절한 에러 메시지 (예: "요청하신 가족 그룹을 찾을 수 없습니다.")
    private final Map<String, Object> details;

    @Getter // FieldError 클래스에도 getter 메소드 자동 생성
    @Builder // FieldError 클래스에도 Builder 패턴 적용
    public static class FieldError {
        private final String field; // 오류가 발생한 필드 이름
        private final String message; // 해당 필드의 오류 메시지
    }

}
