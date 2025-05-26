# 👨‍👩‍👧 Family Care App Frontend

## 📌 프로젝트 개요
**Family Care App**은 아기의 성장 및 건강 기록을 체계적으로 관리하고, 가족 간 육아 정보를 공유할 수 있는 React Native 모바일 애플리케이션입니다.  
직관적인 UI/UX와 실시간 알림을 통해 편리한 육아 관리 경험을 제공합니다.

---

## 📱 지원 플랫폼
- **iOS** 13.0+
- **Android** API Level 21+ (Android 5.0)

---

## ⚙️ 기술 스택

### Core
- **React Native** 0.75+
- **TypeScript** 5.0+
- **Node.js** 22.15.0
- **npm** 10.9.2

### 상태 관리 & 데이터
- **Redux Toolkit** - 전역 상태 관리
- **RTK Query** - API 통신 및 캐싱
- **React Query** - 서버 상태 관리 (대안)
- **AsyncStorage** - 로컬 데이터 저장

### UI/UX
- **React Navigation 6** - 화면 네비게이션
- **React Native Paper** - Material Design 컴포넌트
- **React Native Vector Icons** - 아이콘 라이브러리
- **React Native Animatable** - 애니메이션
- **React Native Chart Kit** - 차트/그래프

### 인증 & 보안
- **React Native Keychain** - 보안 저장소
- **React Native Biometrics** - 생체 인증
- **@react-native-google-signin/google-signin** - Google 로그인
- **@invertase/react-native-apple-authentication** - Apple 로그인

### 푸시 알림 & 실시간
- **@react-native-firebase/messaging** - FCM
- **Socket.io-client** - 실시간 통신
- **React Native Push Notification** - 로컬 알림

### 미디어 & 파일
- **React Native Image Picker** - 사진/동영상 선택
- **React Native Image Crop Picker** - 이미지 편집
- **React Native MMKV** - 고성능 키-값 저장소

### 기타 유틸리티
- **React Native Date Picker** - 날짜/시간 선택
- **React Native Gesture Handler** - 제스처 처리
- **React Native Reanimated 3** - 고성능 애니메이션
- **React Native Safe Area Context** - 안전 영역 처리

---

## 📂 디렉토리 구조

```bash
family-care-app/
├── src/
│   ├── components/          # 재사용 가능한 컴포넌트
│   │   ├── common/         # 공통 컴포넌트 (Button, Input 등)
│   │   ├── forms/          # 폼 관련 컴포넌트
│   │   └── charts/         # 차트/그래프 컴포넌트
│   ├── screens/            # 화면 컴포넌트
│   │   ├── auth/          # 인증 관련 화면
│   │   ├── baby/          # 아기 관리 화면
│   │   ├── record/        # 기록 관리 화면
│   │   ├── family/        # 가족 그룹 화면
│   │   ├── schedule/      # 일정 관리 화면
│   │   └── profile/       # 프로필 화면
│   ├── navigation/         # 내비게이션 설정
│   ├── store/             # Redux 스토어 설정
│   │   ├── slices/        # Redux 슬라이스
│   │   └── api/           # RTK Query API
│   ├── services/          # API 서비스 함수
│   ├── hooks/             # 커스텀 훅
│   ├── utils/             # 유틸리티 함수
│   ├── constants/         # 상수 정의
│   ├── types/             # TypeScript 타입 정의
│   └── assets/            # 정적 리소스 (이미지, 폰트)
├── android/               # Android 네이티브 코드
├── ios/                   # iOS 네이티브 코드
├── __tests__/             # 테스트 파일
└── docs/                  # 문서화
```

---

## 🚀 설치 및 실행

### 사전 요구사항
- **Node.js** 22.15.0
- **npm** 10.9.2
- **React Native CLI**
- **Android Studio** (Android 개발용)
- **Xcode** (iOS 개발용, macOS만)

### 1. 의존성 설치
```bash
# 프로젝트 클론
git clone https://github.com/yourusername/family-care-app.git
cd family-care-app

# Node.js 버전 확인
node --version  # v22.15.0
npm --version   # 10.9.2

# 의존성 설치
npm install

# iOS 의존성 설치 (macOS만)
cd ios && pod install && cd ..
```

### 2. 환경 설정
```bash
# 환경 변수 파일 생성
cp .env.example .env

# .env 파일 편집
REACT_APP_API_BASE_URL=http://localhost:4000/api/v1
REACT_APP_FIREBASE_PROJECT_ID=your-firebase-project-id
REACT_APP_GOOGLE_WEB_CLIENT_ID=your-google-client-id
```

### 3. 애플리케이션 실행
```bash
# Metro 서버 시작
npm start

# Android 실행
npm run android

# iOS 실행 (macOS만)
npm run ios
```

---

## 🧩 주요 기능

### ✅ 인증 시스템
- JWT 토큰 기반 로그인/로그아웃
- Google/Apple 소셜 로그인
- 생체 인증 (지문/Face ID)
- 자동 로그인 및 토큰 갱신

### ✅ 육아 기록 관리
- **아기 프로필**: 기본 정보, 사진 관리
- **일일 기록**: 수유, 수면, 기저귀 갈이 기록
- **성장 기록**: 키, 몸무게, 머리둘레 추적
- **의료 기록**: 병원 방문, 예방접종 일정
- **사진/동영상**: 성장 앨범 관리

### ✅ 실시간 기능
- 가족 구성원 간 실시간 기록 공유
- 푸시 알림을 통한 중요 이벤트 알림
- WebSocket을 통한 실시간 업데이트

### ✅ 통계 및 대시보드
- 수유/수면 패턴 분석
- 성장 차트 및 그래프
- 주간/월간 리포트
- 목표 달성률 추적

### ✅ 가족 그룹 관리
- 가족 구성원 초대 및 권한 설정
- 역할별 접근 권한 제어
- 그룹 내 메시지 및 코멘트

---

## 📅 개발 예정 기능

| 기능                         | 상태   | 예정일    |
|----------------------------|--------|-----------|
| 다크 모드 지원              | 🔜 예정 | 2025.07   |
| 오프라인 모드               | 🔜 예정 | 2025.08   |
| 다국어 지원 (i18n)          | 🔜 예정 | 2025.08   |
| Apple Watch 연동            | 🔜 예정 | 2025.09   |
| 데이터 내보내기/가져오기    | 🔜 예정 | 2025.09   |
| AI 기반 육아 조언           | 🔜 예정 | 2025.10   |
| 음성 기록 기능              | 🔜 예정 | 2025.10   |

---

## 🧪 테스트

### 테스트 도구
- **Jest** - 유닛 테스트
- **React Native Testing Library** - 컴포넌트 테스트
- **Detox** - E2E 테스트 (예정)
- **Maestro** - UI 자동화 테스트 (예정)

### 테스트 실행
```bash
# 유닛 테스트
npm test

# 테스트 커버리지
npm run test:coverage

# 특정 파일 테스트
npm test -- --testPathPattern=src/components/Button
```

---

## 📦 빌드 및 배포

### 개발 빌드
```bash
# Android APK 생성
cd android && ./gradlew assembleDebug

# iOS 빌드 (Xcode에서)
```

### 프로덕션 빌드
```bash
# Android AAB 생성
cd android && ./gradlew bundleRelease

# iOS 아카이브 (Xcode에서 또는 Fastlane 사용)
```

### 자동 배포 (예정)
- **Fastlane** - 자동 빌드 및 배포
- **GitHub Actions** - CI/CD 파이프라인
- **CodePush** - 핫픽스 배포

---

## 🛠️ 개발 도구

### 코드 품질
```bash
# ESLint 실행
npm run lint

# Prettier 포맷팅
npm run format

# TypeScript 타입 체크
npm run type-check
```

### 디버깅
- **React Native Debugger**
- **Flipper** - 네트워크, 레이아웃 디버깅
- **Reactotron** - 상태 관리 디버깅

---

## 📈 성능 최적화

### 주요 최적화 기법
- **코드 스플리팅**: 화면별 번들 분리
- **이미지 최적화**: WebP 포맷 사용, 지연 로딩
- **메모리 관리**: React.memo, useMemo, useCallback 활용
- **네트워크 최적화**: RTK Query 캐싱, 배치 요청

### 성능 모니터링
- **Flipper Performance**: 렌더링 성능 측정
- **React Native Performance**: 메모리 사용량 추적
- **Sentry**: 크래시 및 성능 모니터링 (예정)

---

## 🎨 디자인 시스템

### 컬러 팔레트
```typescript
export const colors = {
  primary: '#4A90E2',
  secondary: '#F5A623',
  success: '#7ED321',
  warning: '#F5A623',
  error: '#D0021B',
  background: '#FFFFFF',
  surface: '#F8F9FA',
  text: '#212529',
  textSecondary: '#6C757D',
};
```

### 타이포그래피
- **Pretendard** - 한글 폰트
- **SF Pro** - iOS 시스템 폰트
- **Roboto** - Android 시스템 폰트

---

## 🤝 기여 가이드

### 커밋 컨벤션
```bash
feat: 새로운 기능 추가
fix: 버그 수정
docs: 문서 수정
style: 코드 포맷팅
refactor: 코드 리팩토링
test: 테스트 추가/수정
chore: 빌드/설정 변경
```

### Pull Request 가이드
1. **Fork** → **Branch 생성** → **개발** → **테스트** → **PR 생성**
2. PR 제목: `[기능] 간단한 설명`
3. 코드 리뷰 완료 후 머지

---

## 📚 문서

### 주요 문서
- [**API 문서**](docs/api.md) - 백엔드 API 연동 가이드
- [**컴포넌트 가이드**](docs/components.md) - 재사용 컴포넌트 사용법
- [**상태 관리**](docs/state-management.md) - Redux 스토어 구조
- [**스타일 가이드**](docs/style-guide.md) - 코딩 스타일 규칙

---

## 🔧 환경 변수

### 필수 환경 변수
```bash
# API 설정
REACT_APP_API_BASE_URL=http://localhost:4000/api/v1
REACT_APP_WS_BASE_URL=ws://localhost:4000

# Firebase 설정
REACT_APP_FIREBASE_PROJECT_ID=your-project-id
REACT_APP_FIREBASE_APP_ID=your-app-id

# 소셜 로그인
REACT_APP_GOOGLE_WEB_CLIENT_ID=your-google-client-id
REACT_APP_APPLE_CLIENT_ID=your-apple-client-id

# 기타
REACT_APP_SENTRY_DSN=your-sentry-dsn
REACT_APP_VERSION=1.0.0
```

---

## 🐛 문제 해결

### 자주 발생하는 문제
1. **Metro 번들러 오류**: `npm start -- --reset-cache`
2. **iOS 빌드 실패**: `cd ios && pod install --repo-update`
3. **Android 빌드 실패**: `cd android && ./gradlew clean`
4. **의존성 충돌**: `npm install --legacy-peer-deps`

---

## 📄 라이선스
MIT License © 2025 Jack

---

## 📞 연락처
- **개발자**: Jack
- **이메일**: jack@example.com
- **이슈 리포트**: [GitHub Issues](https://github.com/yourusername/family-care-app/issues)

---

## 🙏 감사의 글
이 프로젝트는 육아에 도움이 되고자 하는 마음으로 시작되었습니다.  
모든 부모님들의 소중한 육아 여정을 응원합니다! 👶💕