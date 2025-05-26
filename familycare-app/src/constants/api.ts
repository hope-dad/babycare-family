export const API_BASE_URL = __DEV__ 
  ? 'http://localhost:3000/api'  // 개발 환경
  : 'https://your-production-api.com/api';  // 프로덕션 환경

// API Endpoints
export const API_ENDPOINTS = {
  AUTH: {
    LOGIN: '/auth/login',
    REGISTER: '/auth/register',
    LOGOUT: '/auth/logout',
    REFRESH: '/auth/refresh',
    ME: '/auth/me',
    RESET_PASSWORD: '/auth/reset-password',
    CHANGE_PASSWORD: '/auth/change-password',
  },
  BABIES: {
    LIST: '/babies',
    DETAIL: (id: string) => `/babies/${id}`,
    CREATE: '/babies',
    UPDATE: (id: string) => `/babies/${id}`,
    DELETE: (id: string) => `/babies/${id}`,
    GROWTH: (id: string) => `/babies/${id}/growth`,
  },
  RECORDS: {
    FEEDING: (babyId: string) => `/babies/${babyId}/feeding-records`,
    SLEEP: (babyId: string) => `/babies/${babyId}/sleep-records`,
    DIAPER: (babyId: string) => `/babies/${babyId}/diaper-records`,
  },
  FAMILIES: {
    LIST: '/families',
    DETAIL: (id: string) => `/families/${id}`,
    CREATE: '/families',
    INVITE: (id: string) => `/families/${id}/invite`,
    ACCEPT_INVITATION: (invitationId: string) => `/families/invitations/${invitationId}/accept`,
  },
  SCHEDULES: {
    LIST: (babyId: string) => `/babies/${babyId}/schedules`,
    CREATE: (babyId: string) => `/babies/${babyId}/schedules`,
    UPDATE: (id: string) => `/schedules/${id}`,
    DELETE: (id: string) => `/schedules/${id}`,
    VACCINATIONS: (babyId: string) => `/babies/${babyId}/vaccinations`,
  },
} as const;