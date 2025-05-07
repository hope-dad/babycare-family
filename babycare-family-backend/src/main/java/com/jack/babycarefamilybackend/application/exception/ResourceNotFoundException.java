package com.jack.babycarefamilybackend.application.exception;

import lombok.Getter;

import java.util.Map;

@Getter // 모든 필드에 대한 getter 메소드 자동 생성
public class ResourceNotFoundException extends RuntimeException { // RuntimeException 상속

    private final String resourceType; // 어떤 종류의 리소스인지 (예: "Baby", "User")
    private final Object identifier; // 어떤 식별자로 찾으려 했는지 (예: ID 값)
    private final String errorCode; // 커스텀 에러 코드 (예: "BABY_NOT_FOUND", "USER_NOT_FOUND")
    private final Map<String, Object> details; // 예외와 관련된 추가 정보 (선택 사항)


    // 생성자 1: 기본 (resourceType, identifier, message)
    public ResourceNotFoundException(String resourceType, Object identifier, String message) {
        super(message); // 부모 생성자에 메시지 전달
        this.resourceType = resourceType;
        this.identifier = identifier;
        this.errorCode = resourceType.toUpperCase() + "_NOT_FOUND"; // resourceType으로 기본 에러 코드 생성
        this.details = null; // 추가 정보 없음
    }

    // 생성자 2: 에러 코드까지 직접 지정 (resourceType, identifier, errorCode, message)
    public ResourceNotFoundException(String resourceType, Object identifier, String errorCode, String message) {
        super(message);
        this.resourceType = resourceType;
        this.identifier = identifier;
        this.errorCode = errorCode; // 외부에서 지정한 에러 코드 사용
        this.details = null;
    }

    // 생성자 3: 추가 정보 맵까지 포함 (resourceType, identifier, errorCode, message, details)
    public ResourceNotFoundException(String resourceType, Object identifier, String errorCode, String message, Map<String, Object> details) {
        super(message);
        this.resourceType = resourceType;
        this.identifier = identifier;
        this.errorCode = errorCode;
        this.details = details; // 추가 정보 맵 설정
    }

    // 필요하다면 cause를 받는 생성자들도 추가 가능 (RuntimeException에 정의되어 있음)
    // public ResourceNotFoundException(String resourceType, Object identifier, String message, Throwable cause) {
    //     super(message, cause);
    //     this.resourceType = resourceType;
    //     this.identifier = identifier;
    //     this.errorCode = resourceType.toUpperCase() + "_NOT_FOUND";
    //     this.details = null;
    // }

    // serialVersionUID (선택 사항)
    // private static final long serialVersionUID = 1L;
}
