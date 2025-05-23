// src/app/screens/LoginScreen.tsx
import React, { useState } from "react";
import {
  View,
  Text,
  TextInput,
  TouchableOpacity,
  KeyboardAvoidingView,
  Platform,
} from "react-native";
import { loginSuccess } from "../features/auth/authSlice";
import { useDispatch } from "react-redux";
import { useNavigation } from "@react-navigation/native";
import { NativeStackNavigationProp } from "@react-navigation/native-stack";
import { RootStackParamList } from "../navigation/types";
import AppTextInput from "../compoments/AppTextInput";
import AppButton from "../compoments/AppButton";

const LoginScreen = () => {
  const dispatch = useDispatch();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigation =
    useNavigation<NativeStackNavigationProp<RootStackParamList>>();

  const handleLogin = () => {
    dispatch(
      loginSuccess({
        token: "example.token",
        user: {
          id: 1,
          name: "홍길동",
          email: "hong@example.com",
          role: "ADMIN",
        },
      })
    );
    navigation.replace("Home");
  };

  return (
    <KeyboardAvoidingView
      behavior={Platform.OS === "ios" ? "padding" : undefined}
      className="flex-1 bg-[#f7f8fa]"
    >
      <View className="flex-1 justify-center px-8">
        <Text className="text 3xl font-bold text-gray-800 text-center md-3">
          {" "}
          BabyCare Family
        </Text>
        <Text className="text-base text-gray-600 text-center mb-8">
          로그인하여 가족과 함께 관리하세요
        </Text>
      </View>

      <AppTextInput
        placeholder="이메일"
        keyboardType="email-address"
        value={email}
        onChangeText={setEmail}
      />
      <AppTextInput
        placeholder="비밀번호"
        secureTextEntry
        value={password}
        onChangeText={setPassword}
      />

      <AppButton title="로그인" onPress={handleLogin} />
      <TouchableOpacity
        className="mt-6"
        onPress={() => navigation.navigate("Signup")}
      >
        <Text className="text-center text-gray-500 text-sm">
          아직 계정이 없으신가요? 회원가입
        </Text>
      </TouchableOpacity>
    </KeyboardAvoidingView>
  );
};
export default LoginScreen;
