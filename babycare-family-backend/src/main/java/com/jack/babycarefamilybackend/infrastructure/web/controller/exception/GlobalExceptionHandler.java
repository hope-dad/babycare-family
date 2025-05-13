package com.jack.babycarefamilybackend.infrastructure.web.controller.exception;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class) // ResourceNotFoundException 예외 발생 시 이 메소드 호출!
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {

        String resourceType = ex.getResourceType();
        Object identifier = ex.getIdentifier();
        String errorCode = ex.getErrorCode();
        String errorMessage = ex.getMessage();
        Map<String, Object> details = ex.getDetails();

        log.error("ResourceNotFoundException occurred: {} (Type: {}, ID: {}, Code: {}, Details: {})",
                errorMessage, resourceType, identifier, errorCode, details, ex);

        // ✨ 클라이언트에게 반환할 에러 응답 DTO (ErrorResponse) 생성
        ErrorResponse errorResponse = ErrorResponse.builder() // ErrorResponse DTO 빌더 사용
                .timestamp(LocalDateTime.now()) // 발생 시간
                .status(HttpStatus.NOT_FOUND.value()) // HTTP 상태 코드 404
                .error(HttpStatus.NOT_FOUND.getReasonPhrase()) // HTTP 상태 코드 이유 구문 ("Not Found")
                .code(errorCode) // ResourceNotFoundException에서 가져온 에러 코드 (커스텀 코드)
                .message(errorMessage) // ResourceNotFoundException에서 가져온 에러 메시지 (클라이언트에게 보여줄 메시지)
                .path(request.getRequestURI()) // 요청 경로
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND); // 👍 HTTP 상태 코드와 Body 설정!
    }
}
