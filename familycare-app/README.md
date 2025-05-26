# 📦 추가 설치 필요 패키지 목록

## 🔴 필수 설치 패키지

### 1. API 통신 및 데이터 관리
```bash
# RTK Query (API 통신 및 캐싱)
npm install @reduxjs/toolkit/query/react

# HTTP 클라이언트 (axios 또는 fetch 기반)
npm install axios
npm install @tanstack/react-query  # React Query (선택사항, RTK Query 대안)

# 비동기 저장소
npm install @react-native-async-storage/async-storage
```

### 2. UI 컴포넌트 및 스타일링
```bash
# UI 라이브러리
npm install react-native-paper
npm install react-native-elements

# 아이콘 (이미 설치됨, 하지만 설정 필요)
# react-native-vector-icons는 이미 있음

# 날짜/시간 선택기
npm install @react-native-community/datetimepicker
npm install react-native-date-picker

# 이미지 선택 및 처리
npm install react-native-image-picker
npm install react-native-image-crop-picker

# 차트 및 그래프
npm install react-native-chart-kit
npm install react-native-svg  # 차트에 필요
```

### 3. 폼 처리 및 유효성 검사
```bash
# 폼 관리
npm install react-hook-form
npm install @hookform/resolvers

# 유효성 검사
npm install yup
npm install zod  # yup 대안
```

### 4. 인증 및 보안
```bash
# 키체인/키스토어 보안 저장
npm install react-native-keychain

# 소셜 로그인
npm install @react-native-google-signin/google-signin
npm install @invertase/react-native-apple-authentication

# 생체 인증
npm install react-native-biometrics
```

### 5. 푸시 알림 및 실시간 통신
```bash
# Firebase (FCM)
npm install @react-native-firebase/app
npm install @react-native-firebase/messaging

# 실시간 통신
npm install socket.io-client

# 로컬 알림
npm install @react-native-community/push-notification-ios
npm install react-native-push-notification
```

### 6. 권한 관리
```bash
# 권한 요청
npm install react-native-permissions
```

### 7. 유틸리티
```bash
# 날짜 처리
npm install date-fns
npm install moment  # date-fns 대안

# UUID 생성
npm install react-native-uuid

# 디바이스 정보
npm install react-native-device-info

# 네트워크 상태 확인
npm install @react-native-community/netinfo
```

---

## 🟡 개발 도구 (devDependencies)

### 1. 테스트 도구
```bash
# 테스트 프레임워크
npm install --save-dev jest
npm install --save-dev @testing-library/react-native
npm install --save-dev @testing-library/jest-native

# 테스트 유틸리티
npm install --save-dev react-test-renderer
npm install --save-dev @types/jest  # 이미 설치됨
```

### 2. 코드 품질 도구
```bash
# ESLint
npm install --save-dev eslint
npm install --save-dev @typescript-eslint/eslint-plugin
npm install --save-dev @typescript-eslint/parser
npm install --save-dev eslint-plugin-react
npm install --save-dev eslint-plugin-react-native

# Prettier
npm install --save-dev prettier
npm install --save-dev eslint-config-prettier
npm install --save-dev eslint-plugin-prettier

# Husky (Git hooks)
npm install --save-dev husky
npm install --save-dev lint-staged
```

### 3. 빌드 및 배포 도구
```bash
# 환경 변수 관리
npm install react-native-config
npm install --save-dev @types/react-native-config

# 번들 분석
npm install --save-dev @expo/webpack-config
```

---

## 🟢 선택사항 (고급 기능)

### 1. 애니메이션 강화
```bash
# 고급 애니메이션 (react-native-reanimated 이미 설치됨)
npm install react-native-animatable
npm install lottie-react-native
```

### 2. 성능 모니터링
```bash
# 크래시 및 성능 모니터링
npm install @sentry/react-native
```

### 3. 오프라인 지원
```bash
# 오프라인 큐
npm install @react-native-async-storage/async-storage  # 이미 위에 포함됨
npm install react-native-mmkv  # 고성능 저장소
```

---

## 📋 설치 스크립트

### 한 번에 설치 (기본 필수 패키지)
```bash
# 필수 의존성 설치
npm install \
  @reduxjs/toolkit/query/react \
  axios \
  @react-native-async-storage/async-storage \
  react-native-paper \
  @react-native-community/datetimepicker \
  react-native-image-picker \
  react-native-chart-kit \
  react-native-svg \
  react-hook-form \
  @hookform/resolvers \
  yup \
  react-native-keychain \
  @react-native-google-signin/google-signin \
  @react-native-firebase/app \
  @react-native-firebase/messaging \
  socket.io-client \
  react-native-permissions \
  date-fns \
  react-native-uuid \
  @react-native-community/netinfo
```

### 개발 도구 설치
```bash
# 개발 의존성 설치
npm install --save-dev \
  jest \
  @testing-library/react-native \
  @testing-library/jest-native \
  react-test-renderer \
  eslint \
  @typescript-eslint/eslint-plugin \
  @typescript-eslint/parser \
  eslint-plugin-react \
  eslint-plugin-react-native \
  prettier \
  eslint-config-prettier \
  eslint-plugin-prettier \
  husky \
  lint-staged \
  react-native-config \
  @types/react-native-config
```

---

## ⚙️ 설치 후 추가 설정 필요한 패키지

### 1. react-native-vector-icons
```bash
# iOS
cd ios && pod install

# Android: android/app/build.gradle에 설정 추가 필요
```

### 2. @react-native-firebase/app
```bash
# Firebase 설정 파일 추가 필요
# - iOS: GoogleService-Info.plist
# - Android: google-services.json
```

### 3. react-native-permissions
```bash
# iOS: Info.plist 권한 설정
# Android: AndroidManifest.xml 권한 설정
```

### 4. @react-native-google-signin/google-signin
```bash
# Google Console에서 OAuth 설정 필요
```

---

## 📝 업데이트된 package.json scripts 추천

```json
{
  "scripts": {
    "start": "expo start",
    "android": "expo start --android",
    "ios": "expo start --ios",
    "web": "expo start --web",
    "test": "jest",
    "test:watch": "jest --watch",
    "test:coverage": "jest --coverage",
    "lint": "eslint . --ext .js,.jsx,.ts,.tsx",
    "lint:fix": "eslint . --ext .js,.jsx,.ts,.tsx --fix",
    "format": "prettier --write .",
    "type-check": "tsc --noEmit",
    "clean": "expo r -c",
    "prebuild": "expo prebuild --clean",
    "build:android": "eas build --platform android",
    "build:ios": "eas build --platform ios"
  }
}
```

---

## 🎯 우선순위 설치 순서

1. **1순위**: API 통신, 상태관리, 기본 UI
2. **2순위**: 폼 처리, 인증, 권한
3. **3순위**: 푸시알림, 실시간 통신
4. **4순위**: 고급 기능, 성능 최적화
5. **5순위**: 개발 도구, 테스트

현재 기본적인 네비게이션과 상태관리는 설치되어 있으니, API 통신과 UI 컴포넌트부터 시작하시는 것을 추천합니다!