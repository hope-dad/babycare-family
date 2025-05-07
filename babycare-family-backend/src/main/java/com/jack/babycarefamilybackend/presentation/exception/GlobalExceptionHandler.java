package com.jack.babycarefamilybackend.presentation.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) { // HttpServletRequest로 path 얻어오기
        System.err.println("잘못된 인자 예외 발생: " + ex.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder() // <-- Builder 시작!
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value()) // 400
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase()) // "Bad Request"
                .code("INVALID_INPUT") // 네 커스텀 코드
                .message(ex.getMessage()) // 예외 메시지 사용
                .path(request.getRequestURI()) // 요청 경로
                // .errors(...) // 유효성 검사 에러 목록은 필요 없으니 안 넣어
                .build(); // <-- Builder 끝! 객체 생성 완료!

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
