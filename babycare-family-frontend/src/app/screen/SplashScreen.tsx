// src/app/screens/SplashScreen.tsx
import React, { useEffect } from 'react';
import { View, Text, ActivityIndicator } from 'react-native';
import { useNavigation } from '@react-navigation/native';
import { useAppSelector } from '../../hooks/useAppSelector';

const SplashScreen = () => {
  const navigation = useNavigation<any>();
  const { isLoggedIn } = useAppSelector(state => state.auth);

  useEffect(() => {
    const timeout = setTimeout(() => {
      navigation.replace(isLoggedIn ? 'Home' : 'Login');
    }, 1000);
    return () => clearTimeout(timeout);
  }, [isLoggedIn]);

  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <ActivityIndicator size="large" />
      <Text>Loading...</Text>
    </View>
  );
};

export default SplashScreen;
