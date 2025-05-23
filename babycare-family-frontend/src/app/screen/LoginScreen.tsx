// src/app/screens/LoginScreen.tsx
import React from 'react';
import { View, Text, Button } from 'react-native';
import { loginSuccess } from '../../features/auth/authSlice';
import { useAppDispatch } from '../../hooks/useAppDispatch';

const LoginScreen = () => {
  const dispatch = useAppDispatch();

  const handleLogin = () => {
    dispatch(
      loginSuccess({
        token: 'example.token',
        user: {
          id: 1,
          name: '홍길동',
          email: 'hong@example.com',
          role: 'ADMIN',
        },
      })
    );
  };

  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Text>로그인 화면</Text>
      <Button title="로그인" onPress={handleLogin} />
    </View>
  );
};

export default LoginScreen;
