import React, { useState } from "react";
import {
  Text,
  TextInput,
  TextInputProps,
  TouchableOpacity,
  View,
} from "react-native";
import clsx from "clsx";

interface AppTextInputProps extends TextInputProps {
  label?: string;
  error?: string;
  helperText?: string;
  leftIcon?: React.ReactNode;
  rightIcon?: React.ReactNode;
  variant?: "default" | "outlined" | "filled";
  size?: "small" | "medium" | "large";
  required?: boolean;
  showPasswordToggle?: boolean;
}

const AppTextInput: React.FC<AppTextInputProps> = ({
  label,
  error,
  helperText,
  leftIcon,
  rightIcon,
  variant = "default",
  size = "medium",
  required = false,
  showPasswordToggle = false,
  secureTextEntry,
  ...props
}) => {
  const [isFocused, setIsFocused] = useState(false);
  const [isPasswordVisible, setIsPasswordVisible] = useState(false);

  const isSecure = secureTextEntry && !isPasswordVisible;

  const togglePasswordVisibility = () =>
    setIsPasswordVisible((prev) => !prev);

  return (
    <View className="mb-4">
      {label && (
        <Text className="text-sm font-medium text-gray-700 mb-2">
          {label}
          {required && <Text className="text-red-500 ml-1">*</Text>}
        </Text>
      )}
      <View className="relative">
        {leftIcon && (
          <View className="absolute left-3 top-1/2 transform -translate-y-1/2 z-10">
            {leftIcon}
          </View>
        )}
        <TextInput
          className={clsx(
            "rounded-lg px-4",
            {
              "h-10 text-sm": size === "small",
              "h-12 text-base": size === "medium",
              "h-14 text-lg": size === "large",
            },
            {
              "bg-white border border-gray-300": variant === "default",
              "bg-transparent border-2 border-gray-300": variant === "outlined",
              "bg-gray-100 border border-transparent": variant === "filled",
            },
            isFocused && "border-indigo-500",
            error && "border-red-500",
            leftIcon && "pl-12",
            (rightIcon || showPasswordToggle) && "pr-12"
          )}
          placeholderTextColor="#9CA3AF"
          secureTextEntry={isSecure}
          onFocus={() => setIsFocused(true)}
          onBlur={() => setIsFocused(false)}
          {...props}
        />
        {(rightIcon || showPasswordToggle) && (
          <View className="absolute right-3 top-1/2 transform -translate-y-1/2">
            {showPasswordToggle && secureTextEntry ? (
              <TouchableOpacity onPress={togglePasswordVisibility}>
                <Text className="text-gray-500 text-sm">
                  {isPasswordVisible ? "숨김" : "보기"}
                </Text>
              </TouchableOpacity>
            ) : (
              rightIcon
            )}
          </View>
        )}
      </View>
      {(error || helperText) && (
        <Text
          className={clsx("text-xs mt-1", {
            "text-red-500": !!error,
            "text-gray-500": !error,
          })}
        >
          {error || helperText}
        </Text>
      )}
    </View>
  );
};

export default AppTextInput;
