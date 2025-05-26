# 👨‍👩‍👧 Family Care App Backend

## 📌 프로젝트 개요

**Family Care App**은 아기의 성장 및 건강 기록을 체계적으로 관리하고, 가족 간 육아 정보를 공유할 수 있도록 도와주는 백엔드 시스템입니다.  
Spring Boot 기반으로 개발되었으며, 클린 아키텍처를 따릅니다.

---

## 📂 디렉토리 구조

```bash
com.jack.babycarefamilybackend
├── application
│   ├── port               # UseCase 인터페이스 정의
│   └── usecase            # 애플리케이션 로직 (각 도메인별 유스케이스)
│       ├── baby
│       ├── checklist
│       ├── comment
│       ├── familygroup
│       ├── record
│       ├── schedule
│       └── user
├── common
│   ├── exception          # 커스텀 예외 정의
│   └── util               # 공통 유틸리티 클래스
├── domain                 # 엔티티 및 도메인 모델
├── infrastructure
│   ├── config             # 설정 클래스 (Security, Swagger 등)
│   ├── external           # 외부 연동 모듈 (S3, FCM 등)
│   ├── mapper             # DTO ↔ Entity 매핑 클래스
│   ├── persistence        # JPA Repository 구현체
│   └── web                # Controller 계층
└── BabycareFamilyBackendApplication.java  # Spring Boot 진입점
```

---

## ⚙️ 기술 스택

- Java 21
- Spring Boot 3.4
- Spring Security + JWT
- JPA (Hibernate)
- MySQL
- Redis
- AWS S3 (파일 업로드)
- Firebase Cloud Messaging (FCM)
- WebSocket
- Quartz Scheduler
- Logback, Swagger

---

## 🧩 주요 기능

### ✅ 인증 및 인가
- JWT 기반 로그인/로그아웃
- 역할 기반 접근 제어 (부모, 보호자 등)
- Google / Apple 소셜 로그인 예정

### ✅ 육아 기록 관리
- 아기 정보 등록 및 수정
- 수유/수면/기저귀 기록
- 성장 및 질병 기록
- 병원 방문, 의료 이력, 예방접종 관리

### ✅ 가족 그룹
- 가족 구성원 초대 및 권한 설정
- 그룹 내 사용자와 기록 공유

### ✅ 알림 시스템
- FCM 기반 푸시 알림
- 예방 접종, 일정 등 주요 이벤트 알림

### ✅ 통계 API
- 수면, 수유 등 기록 통계 제공
- 대시보드 시각화용 API

### ✅ 실시간 기능
- WebSocket을 통한 실시간 기록 공유

---

## 📅 예정 기능

| 기능                         | 상태   |
|----------------------------|--------|
| 소셜 로그인                 | 🔜 예정 |
| API 버전 관리               | 🔜 예정 |
| 데이터 백업/복구 API        | 🔜 예정 |
| 다국어(i18n) 지원           | 🔜 예정 |
| 검색 및 필터링 기능         | 🔜 예정 |
| Rate Limiting              | 🔜 예정 |
| CI/CD 파이프라인 구축       | 🔜 예정 |

---


## 🧪 테스트

- **JUnit5**, **Mockito** 기반 유닛 및 통합 테스트 작성
- Postman / Swagger로 API 테스트 진행
- 테스트 커버리지 목표: 80% 이상

---

## 📈 모니터링 및 로깅

- `Spring Boot Actuator` + `Prometheus` + `Grafana`
- 로그 수집: `Logback`, `ELK Stack`, `Sentry`

---

## 🤝 기여 가이드

1. Fork → 수정 → Pull Request
2. 커밋 메시지 컨벤션 유지 (e.g., `feat: 가족 그룹 초대 API 추가`)
3. Swagger 문서 유지 필수

---

## 🧠 참고 아키텍처

- 클린 아키텍처 기반의 계층적 구조
- 도메인 중심 설계 (DDD Lite)
- 각 계층 간 의존성 역전 유지

---

## 📝 License

MIT License © 2025 Jack
