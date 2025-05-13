# Family Care App Backend

## 📦 **프로젝트 개요**
Family Care App은 아기의 성장, 건강 기록을 관리하고 가족 간 소통을 돕기 위한 앱입니다.  
Backend는 Spring Boot를 기반으로 구현되었으며, 주요 도메인은 다음과 같습니다:

- 아기정보
- 체크리스트
- 코멘트
- 가족그룹
- 성장 기록
- 기저귀 리코드
- 수유기록 리코드
- 수면 기록 리코드
- 일정 기록
- 의료 기록 리코드
- 병원 방문 기록 리코드
- 예방 접종 리코드
- 질병 기록 리코드
- 유저

---

## 🛠️ **기술 스택**

- Java 21
- Spring Boot 3.4
- Spring Security
- JWT Authentication
- JPA/Hibernate
- MySQL
- Redis (세션 관리 및 캐싱)
- AWS S3 (파일 업로드)
- Firebase Cloud Messaging (푸시 알림)
- WebSockets (실시간 업데이트)
- Quartz Scheduler (배치 작업)
- Logback (로그 관리)
- Swagger (API 문서화)

---

## ✅ **구현 예정 기능**

### 1. 인증 및 인가 (Authentication & Authorization)
- JWT 기반 인증 구현
- 유저 역할(Role) 기반 접근 제어 (부모, 보호자, 병원 관계자 등)
- 소셜 로그인 (Google, Apple)

---

### 2. 알림(Notification) 시스템
- 푸시 알림, 이메일 알림, 앱 내 알림
- 일정 기록, 예방 접종 리코드, 병원 방문 리코드에 대한 알림 트리거
- Firebase Cloud Messaging (FCM) 사용

---

### 3. 데이터 보안 및 개인정보 보호
- 민감한 정보 암호화 (의료 기록, 질병 기록 등)
- HTTPS 및 CORS 설정
- GDPR, CCPA 준수

---

### 4. 이미지 및 파일 업로드
- S3를 통한 이미지 업로드
- 이미지 리사이징 및 썸네일 생성

---

### 5. 통계 및 대시보드 API
- 성장 기록, 수면 기록, 수유기록 등을 시각화하는 통계 API
- 차트 데이터 제공

---

### 6. 실시간 업데이트
- WebSocket 또는 Server-Sent Events (SSE)를 통한 실시간 데이터 업데이트

---

### 7. 데이터 백업 및 복구
- 데이터 백업 스케줄링
- 데이터 복구 및 복원 API

---

### 8. 검색 및 필터링 기능
- 기록별 검색 (수유 기록, 예방 접종 기록 등)
- 날짜, 유형별 필터링

---

### 9. 다국어 지원 (i18n)
- 텍스트 및 알림 메시지에 대한 다국어 지원

---

### 10. 스케줄링 및 배치 작업
- Spring Scheduler 또는 Quartz를 사용하여 일정 알림, 예방 접종 리마인더 등 자동화

---

### 11. 테스트 및 문서화
- API 문서화: Swagger/OpenAPI
- 유닛 테스트, 통합 테스트 작성 (JUnit, Mockito)
- Postman 또는 Insomnia로 API 테스트

---

### 12. API Rate Limiting & Monitoring
- Rate Limiting 설정 (API 악용 방지)
- Spring Boot Actuator, Prometheus, Grafana를 통한 애플리케이션 성능 모니터링

---

### 13. 버전 관리 및 CI/CD
- API 버전 관리 (v1, v2)
- CI/CD 파이프라인 구축 (GitHub Actions, Jenkins, GitLab CI)

---

### 14. 로그 관리 및 에러 트래킹
- Logback, ELK Stack (Elasticsearch, Logstash, Kibana)로 로그 관리
- Sentry 또는 Datadog을 통한 에러 모니터링

---

## 🚀 **프로젝트 실행 방법**

1. **프로젝트 클론**
   ```bash
   git clone https://github.com/your-repo/family-care-backend.git
   cd family-care-backend
