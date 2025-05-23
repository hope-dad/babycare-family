import React from "react";
import {
  ActivityIndicator,
  Text,
  TouchableOpacity,
  TouchableOpacityProps,
  View,
} from "react-native";
import clsx from "clsx";

interface AppButtonProps extends TouchableOpacityProps {
  title: string;
  variant?: "primary" | "secondary" | "outline" | "danger";
  size?: "small" | "medium" | "large";
  loading?: boolean;
  fullWidth?: boolean;
}

const AppButton: React.FC<AppButtonProps> = ({
  title,
  variant = "primary",
  size = "medium",
  loading = false,
  fullWidth = true,
  disabled,
  ...props
}) => {
  const isDisabled = disabled || loading;

  return (
    <TouchableOpacity
      disabled={isDisabled}
      activeOpacity={0.8}
      className={clsx(
        "rounded-lg justify-center items-center mt-2",
        fullWidth && "w-full",
        isDisabled && "opacity-50",
        {
          "bg-indigo-600 border border-indigo-600": variant === "primary",
          "bg-gray-100 border border-gray-300": variant === "secondary",
          "bg-transparent border-2 border-indigo-600": variant === "outline",
          "bg-red-600 border border-red-600": variant === "danger",
        },
        {
          "h-10 px-4": size === "small",
          "h-12 px-6": size === "medium",
          "h-14 px-8": size === "large",
        }
      )}
      {...props}
    >
      {loading ? (
        <ActivityIndicator
          size="small"
          color={
            variant === "outline" || variant === "secondary"
              ? "#4F46E5"
              : "#FFFFFF"
          }
        />
      ) : (
        <Text
          className={clsx("font-semibold", {
            "text-white": variant === "primary" || variant === "danger",
            "text-gray-700": variant === "secondary",
            "text-indigo-600": variant === "outline",
            "text-sm": size === "small",
            "text-base": size === "medium",
            "text-lg": size === "large",
          })}
        >
          {title}
        </Text>
      )}
    </TouchableOpacity>
  );
};

export default AppButton;
