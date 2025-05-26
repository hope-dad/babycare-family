familycare-app/
├── src/
│   ├── components/                 # 재사용 가능한 컴포넌트
│   │   ├── common/                # 공통 컴포넌트
│   │   │   ├── Button/
│   │   │   │   ├── index.tsx
│   │   │   │   ├── styles.ts
│   │   │   │   └── types.ts
│   │   │   ├── Input/
│   │   │   │   ├── index.tsx
│   │   │   │   ├── styles.ts
│   │   │   │   └── types.ts
│   │   │   ├── Card/
│   │   │   ├── Modal/
│   │   │   ├── Loading/
│   │   │   ├── EmptyState/
│   │   │   └── index.ts           # 컴포넌트 export
│   │   ├── forms/                 # 폼 관련 컴포넌트
│   │   │   ├── BabyForm/
│   │   │   ├── RecordForm/
│   │   │   ├── ProfileForm/
│   │   │   └── index.ts
│   │   ├── charts/                # 차트/그래프 컴포넌트
│   │   │   ├── GrowthChart/
│   │   │   ├── FeedingChart/
│   │   │   ├── SleepChart/
│   │   │   └── index.ts
│   │   └── layout/                # 레이아웃 컴포넌트
│   │       ├── Header/
│   │       ├── TabBar/
│   │       ├── SafeAreaWrapper/
│   │       └── index.ts
│   │
│   ├── screens/                   # 화면 컴포넌트
│   │   ├── auth/                  # 인증 화면
│   │   │   ├── LoginScreen/
│   │   │   │   ├── index.tsx
│   │   │   │   ├── styles.ts
│   │   │   │   └── types.ts
│   │   │   ├── RegisterScreen/
│   │   │   ├── ForgotPasswordScreen/
│   │   │   └── index.ts
│   │   ├── baby/                  # 아기 관리 화면
│   │   │   ├── BabyListScreen/
│   │   │   ├── BabyDetailScreen/
│   │   │   ├── AddBabyScreen/
│   │   │   ├── EditBabyScreen/
│   │   │   └── index.ts
│   │   ├── record/                # 기록 관리 화면
│   │   │   ├── RecordListScreen/
│   │   │   ├── AddRecordScreen/
│   │   │   ├── FeedingRecordScreen/
│   │   │   ├── SleepRecordScreen/
│   │   │   ├── DiaperRecordScreen/
│   │   │   └── index.ts
│   │   ├── family/                # 가족 그룹 화면
│   │   │   ├── FamilyListScreen/
│   │   │   ├── FamilyDetailScreen/
│   │   │   ├── InviteFamilyScreen/
│   │   │   └── index.ts
│   │   ├── schedule/              # 일정 관리 화면
│   │   │   ├── ScheduleListScreen/
│   │   │   ├── AddScheduleScreen/
│   │   │   ├── VaccinationScreen/
│   │   │   └── index.ts
│   │   ├── profile/               # 프로필 화면
│   │   │   ├── ProfileScreen/
│   │   │   ├── SettingsScreen/
│   │   │   ├── EditProfileScreen/
│   │   │   └── index.ts
│   │   └── dashboard/             # 대시보드 화면
│   │       ├── DashboardScreen/
│   │       ├── StatisticsScreen/
│   │       └── index.ts
│   │
│   ├── navigation/                # 내비게이션 설정
│   │   ├── AppNavigator.tsx       # 메인 네비게이터
│   │   ├── AuthNavigator.tsx      # 인증 네비게이터
│   │   ├── TabNavigator.tsx       # 탭 네비게이터
│   │   ├── StackNavigator.tsx     # 스택 네비게이터
│   │   ├── types.ts               # 네비게이션 타입
│   │   └── index.ts
│   │
│   ├── store/                     # Redux 스토어 설정
│   │   ├── index.ts               # 스토어 설정
│   │   ├── rootReducer.ts         # 루트 리듀서
│   │   ├── middleware.ts          # 미들웨어 설정
│   │   ├── slices/                # Redux 슬라이스
│   │   │   ├── authSlice.ts
│   │   │   ├── babySlice.ts
│   │   │   ├── recordSlice.ts
│   │   │   ├── familySlice.ts
│   │   │   ├── scheduleSlice.ts
│   │   │   ├── uiSlice.ts
│   │   │   └── index.ts
│   │   └── api/                   # RTK Query API
│   │       ├── baseApi.ts         # 기본 API 설정
│   │       ├── authApi.ts
│   │       ├── babyApi.ts
│   │       ├── recordApi.ts
│   │       ├── familyApi.ts
│   │       ├── scheduleApi.ts
│   │       └── index.ts
│   │
│   ├── services/                  # API 서비스 함수
│   │   ├── api/                   # API 통신
│   │   │   ├── client.ts          # Axios 클라이언트
│   │   │   ├── endpoints.ts       # API 엔드포인트
│   │   │   ├── interceptors.ts    # 요청/응답 인터셉터
│   │   │   └── types.ts
│   │   ├── auth/                  # 인증 서비스
│   │   │   ├── authService.ts
│   │   │   ├── tokenService.ts
│   │   │   └── socialAuthService.ts
│   │   ├── storage/               # 로컬 저장소
│   │   │   ├── secureStorage.ts
│   │   │   ├── asyncStorage.ts
│   │   │   └── index.ts
│   │   ├── notification/          # 알림 서비스
│   │   │   ├── pushNotification.ts
│   │   │   ├── localNotification.ts
│   │   │   └── index.ts
│   │   └── permission/            # 권한 서비스
│   │       ├── permissionService.ts
│   │       └── index.ts
│   │
│   ├── hooks/                     # 커스텀 훅
│   │   ├── useApi.ts              # API 호출 훅
│   │   ├── useAuth.ts             # 인증 관련 훅
│   │   ├── useForm.ts             # 폼 관련 훅
│   │   ├── usePermission.ts       # 권한 관련 훅
│   │   ├── useNotification.ts     # 알림 관련 훅
│   │   ├── useDebounce.ts         # 디바운스 훅
│   │   ├── useStorage.ts          # 저장소 관련 훅
│   │   └── index.ts
│   │
│   ├── utils/                     # 유틸리티 함수
│   │   ├── date.ts                # 날짜 관련 함수
│   │   ├── validation.ts          # 유효성 검사 함수
│   │   ├── format.ts              # 포맷팅 함수
│   │   ├── helpers.ts             # 헬퍼 함수
│   │   ├── constants.ts           # 상수 정의
│   │   ├── logger.ts              # 로깅 유틸
│   │   └── index.ts
│   │
│   ├── constants/                 # 상수 정의
│   │   ├── api.ts                 # API 관련 상수
│   │   ├── colors.ts              # 컬러 팔레트
│   │   ├── fonts.ts               # 폰트 관련
│   │   ├── sizes.ts               # 크기 관련
│   │   ├── strings.ts             # 문자열 상수
│   │   ├── routes.ts              # 라우트 상수
│   │   └── index.ts
│   │
│   ├── types/                     # TypeScript 타입 정의
│   │   ├── api.ts                 # API 타입
│   │   ├── auth.ts                # 인증 타입
│   │   ├── baby.ts                # 아기 관련 타입
│   │   ├── record.ts              # 기록 관련 타입
│   │   ├── family.ts              # 가족 관련 타입
│   │   ├── schedule.ts            # 일정 관련 타입
│   │   ├── common.ts              # 공통 타입
│   │   ├── navigation.ts          # 네비게이션 타입
│   │   └── index.ts
│   │
│   ├── styles/                    # 스타일 관련
│   │   ├── theme.ts               # 테마 설정
│   │   ├── globalStyles.ts        # 전역 스타일
│   │   ├── mixins.ts              # 스타일 믹스인
│   │   └── index.ts
│   │
│   └── assets/                    # 정적 리소스
│       ├── images/                # 이미지 파일
│       │   ├── icons/
│       │   ├── logos/
│       │   └── illustrations/
│       ├── fonts/                 # 폰트 파일
│       └── data/                  # 정적 데이터
│           └── mock.ts
│
├── __tests__/                     # 테스트 파일
│   ├── components/
│   ├── screens/
│   ├── hooks/
│   ├── utils/
│   └── __mocks__/
│
├── docs/                          # 문서화
│   ├── api.md
│   ├── components.md
│   ├── state-management.md
│   └── style-guide.md
│
├── android/                       # Android 네이티브 코드
├── ios/                          # iOS 네이티브 코드
├── assets/                       # Expo 에셋
├── .env.example                  # 환경 변수 예시
├── .eslintrc.js                  # ESLint 설정
├── .prettierrc.js                # Prettier 설정
├── babel.config.js               # Babel 설정
├── metro.config.js               # Metro 설정
├── tsconfig.json                 # TypeScript 설정
├── tailwind.config.js            # Tailwind 설정
├── app.config.js                 # Expo 설정
├── package.json
└── README.md