// src/app/screens/HomeScreen.tsx
import React from 'react';
import { View, Text, Button } from 'react-native';
import { logout } from '../../features/auth/authSlice';
import { useAppDispatch } from '../../hooks/useAppDispatch';

const HomeScreen = () => {
  const dispatch = useAppDispatch();

  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Text>홈 화면</Text>
      <Button title="로그아웃" onPress={() => dispatch(logout())} />
    </View>
  );
};

export default HomeScreen;
