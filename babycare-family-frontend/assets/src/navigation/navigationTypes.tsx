// src/app/navigation/RootNavigator.tsx
import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { useAppSelector } from '../../hooks/useAppSelector';
import SplashScreen from '../screen/SplashScreen';
import LoginScreen from '../screen/LoginScreen';
import HomeScreen from '../screen/HomeScreen';

export type RootStackParamList = {
  Splash: undefined;
  Login: undefined;
  Home: undefined;
};

const Stack = createNativeStackNavigator<RootStackParamList>();

const RootNavigator = () => {
  const { isLoggedIn } = useAppSelector(state => state.auth);

  return (
    <NavigationContainer>
      <Stack.Navigator screenOptions={{ headerShown: false }}>
        {/* 첫 화면을 Splash로 지정 */}
        <Stack.Screen name="Splash" component={SplashScreen} />
        {!isLoggedIn ? (
          <Stack.Screen name="Login" component={LoginScreen} />
        ) : (
          <Stack.Screen name="Home" component={HomeScreen} />
        )}
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default RootNavigator;
