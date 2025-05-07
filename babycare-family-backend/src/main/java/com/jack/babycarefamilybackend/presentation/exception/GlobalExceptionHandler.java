package com.jack.babycarefamilybackend.presentation.exception;

import com.jack.babycarefamilybackend.application.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    // --- 모든 ResourceNotFoundException 계열 예외를 여기서 한방에 처리! ---
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        // 잡힌 예외 객체(ex)에서 추가 정보들을 꺼내옵니다!
        String resourceType = ex.getResourceType(); // "Baby", "User" 등
        Object identifier = ex.getIdentifier(); // 123L, "abc" 등 ID 값
        String errorCode = ex.getErrorCode(); // "BABY_NOT_FOUND", "USER_NOT_FOUND" 등
        String errorMessage = ex.getMessage(); // "Baby with ID 123 not found" 등
        Map<String, Object> details = ex.getDetails(); // 추가 정보 맵 (null일 수도 있음)

        System.err.println("ResourceNotFoundException 발생: " + errorMessage +
                " (Type: " + resourceType + ", ID: " + identifier + ", Code: " + errorCode + ", Details: " + details + ")");

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value()) // 404
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .code(errorCode) // 예외 객체에서 얻어온 errorCode 사용!
                .message(errorMessage) // 예외 객체에서 얻어온 errorMessage 사용!
                .path(request.getRequestURI())
                // .errors(...) // 유효성 검사 에러는 아니므로 이건 null
                // 추가 정보 맵을 ErrorResponse에 포함시키고 싶다면 ErrorResponse DTO에 필드를 추가해야 함
                // .details(details) // ErrorResponse에 details 필드를 추가했다면 이렇게 사용
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
