import { createSlice, PayloadAction } from "@reduxjs/toolkit";

type UserRole = 'ADMIN' | 'MEMBER' | 'PARENT' | 'GUARDIAN' | 'DOCTOR';

interface User {
  id: number;
  name: string; // 추가
  email: string;
  role: UserRole; // 확장
  famiyGroudId?: number;
}

interface AuthState {
  isLoggedIn: boolean;
  token: string | null;
  user: User | null;
}

const initialState: AuthState = {
  isLoggedIn: false,
  token: null,
  user: null
};

const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    loginSuccess(state, action: PayloadAction<{ token: string, user: User }>) {
      state.isLoggedIn = true;
      state.token = action.payload.token;
      state.user = action.payload.user;
    },
    logout(state) {
      state.isLoggedIn = false;
      state.token = null;
      state.user = null;
    },
    updateUserInfo(state, action: PayloadAction<Partial<User>>) {
      if (state.user) {
        state.user = { ...state.user, ...action.payload };
      }
    }
  }
});

export const { loginSuccess, logout, updateUserInfo } = authSlice.actions;
export default authSlice.reducer;