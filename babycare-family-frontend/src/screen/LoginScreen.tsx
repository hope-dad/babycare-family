// src/app/screens/LoginScreen.tsx
import React, { useState } from "react";
import {
  View,
  Text,
  Alert,
  KeyboardAvoidingView,
  Platform,
  TouchableOpacity,
  ScrollView,
} from "react-native";
import { useDispatch } from "react-redux";
import { useNavigation } from "@react-navigation/native";
import { NativeStackNavigationProp } from "@react-navigation/native-stack";
import { loginSuccess } from "../features/auth/authSlice";
import { RootStackParamList } from "../navigation/types";
import AppTextInput from "@/compoments/AppTextInput";
import AppButton from "@/compoments/AppButton";

type LoginScreenNavigationProp = NativeStackNavigationProp<RootStackParamList>;

const LoginScreen: React.FC = () => {
  const dispatch = useDispatch();
  const navigation = useNavigation<LoginScreenNavigationProp>();
  
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [isLoading, setIsLoading] = useState(false);

  // 이메일 유효성 검사
  const validateEmail = (email: string): boolean => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  };

  // 폼 유효성 검사
  const validateForm = (): boolean => {
    if (!email.trim()) {
      Alert.alert("오류", "이메일을 입력해주세요.");
      return false;
    }
    
    if (!validateEmail(email)) {
      Alert.alert("오류", "올바른 이메일 형식을 입력해주세요.");
      return false;
    }
    
    if (!password.trim()) {
      Alert.alert("오류", "비밀번호를 입력해주세요.");
      return false;
    }
    
    if (password.length < 6) {
      Alert.alert("오류", "비밀번호는 최소 6자 이상이어야 합니다.");
      return false;
    }
    
    return true;
  };

  const handleLogin = async () => {
    if (!validateForm()) return;

    setIsLoading(true);
    
    try {
      await new Promise(resolve => setTimeout(resolve, 1500)); // 로딩 시뮬레이션
      
      dispatch(
        loginSuccess({
          token: "example.token",
          user: {
            id: 1,
            name: "홍길동",
            email: email,
            role: "ADMIN",
          },
        })
      );
      
      navigation.replace("Home");
    } catch (error) {
      Alert.alert("로그인 실패", "이메일 또는 비밀번호를 확인해주세요.");
    } finally {
      setIsLoading(false);
    }
  };

  const handleSignupNavigation = () => {
    navigation.navigate("Signup");
  };

  return (
    <KeyboardAvoidingView
      behavior={Platform.OS === "ios" ? "padding" : "height"}
      className="flex-1 bg-[#f7f8fa]"
    >
      <ScrollView 
        contentContainerStyle={{ flexGrow: 1 }}
        keyboardShouldPersistTaps="handled"
        showsVerticalScrollIndicator={false}
      >
        <View className="flex-1 justify-center px-8 py-8">
          {/* 헤더 섹션 */}
          <View className="items-center mb-12">
            <Text className="text-3xl font-bold text-gray-800 text-center mb-3">
              BabyCare Family
            </Text>
            <Text className="text-base text-gray-600 text-center">
              로그인하여 가족과 함께 관리하세요
            </Text>
          </View>

          {/* 입력 폼 섹션 */}
          <View className="mb-6">
            <AppTextInput
              placeholder="이메일"
              keyboardType="email-address"
              autoCapitalize="none"
              autoCorrect={false}
              value={email}
              onChangeText={setEmail}
              returnKeyType="next"
            />
            
            <AppTextInput
              placeholder="비밀번호"
              secureTextEntry
              value={password}
              onChangeText={setPassword}
              returnKeyType="done"
              onSubmitEditing={handleLogin}
            />
          </View>

          {/* 로그인 버튼 */}
          <AppButton
            title={isLoading ? "로그인 중..." : "로그인"} 
            onPress={handleLogin}
            disabled={isLoading}
            className={isLoading ? "opacity-50" : ""}
          />

          {/* 회원가입 링크 */}
          <TouchableOpacity
            className="mt-6"
            onPress={handleSignupNavigation}
            disabled={isLoading}
          >
            <Text className="text-center text-gray-500 text-sm">
              아직 계정이 없으신가요?{" "}
              <Text className="text-indigo-600 font-medium">회원가입</Text>
            </Text>
          </TouchableOpacity>

          {/* 추가 옵션들 */}
          <TouchableOpacity className="mt-4" disabled={isLoading}>
            <Text className="text-center text-gray-400 text-sm">
              비밀번호를 잊으셨나요?
            </Text>
          </TouchableOpacity>
        </View>
      </ScrollView>
    </KeyboardAvoidingView>
  );
};

export default LoginScreen;