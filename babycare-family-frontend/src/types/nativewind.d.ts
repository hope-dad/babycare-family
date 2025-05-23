/// <reference types="nativewind/types" />

import "react-native";

declare module "react-native" {
  // 기본 컴포넌트 Props에 className 추가
  interface ViewProps {
    className?: string;
  }

  interface TextProps {
    className?: string;
  }

  interface TextInputProps {
    className?: string;
  }

  interface ImageProps {
    className?: string;
  }

  interface ScrollViewProps {
    className?: string;
  }

  interface SafeAreaViewProps {
    className?: string;
  }

  interface FlatListProps<ItemT> {
    className?: string;
  }

  interface SectionListProps<ItemT, SectionT> {
    className?: string;
  }

  // 터치 관련 컴포넌트
  interface TouchableOpacityProps {
    className?: string;
  }

  interface TouchableHighlightProps {
    className?: string;
  }

  interface TouchableWithoutFeedbackProps {
    className?: string;
  }

  interface PressableProps {
    className?: string;
  }

  // 입력 관련 컴포넌트
  interface SwitchProps {
    className?: string;
  }

  interface SliderProps {
    className?: string;
  }

  // 모달 및 오버레이
  interface ModalProps {
    className?: string;
  }

  interface KeyboardAvoidingViewProps {
    className?: string;
  }

  // 상태 표시 컴포넌트
  interface ActivityIndicatorProps {
    className?: string;
  }

  interface ProgressBarAndroidProps {
    className?: string;
  }

  interface ProgressViewIOSProps {
    className?: string;
  }

  // 기타 유용한 컴포넌트
  interface RefreshControlProps {
    className?: string;
  }

  interface StatusBarProps {
    className?: string;
  }
}

// React Navigation과 함께 사용하는 경우 (선택사항)
declare module "@react-navigation/native" {
  interface NavigationContainerProps {
    className?: string;
  }
}

// 써드파티 라이브러리와 함께 사용하는 경우 (예시)
declare module "react-native-safe-area-context" {
  interface SafeAreaViewProps {
    className?: string;
  }
  
  interface SafeAreaProviderProps {
    className?: string;
  }
}

// Expo 컴포넌트 지원 (Expo 사용 시)
declare module "expo-linear-gradient" {
  interface LinearGradientProps {
    className?: string;
  }
}

declare module "expo-blur" {
  interface BlurViewProps {
    className?: string;
  }
}

// NativeWind 전용 타입 확장
declare global {
  namespace JSX {
    interface IntrinsicAttributes {
      className?: string;
    }
  }
}

// 커스텀 컴포넌트를 위한 유틸리티 타입
export interface WithClassName {
  className?: string;
}

// 스타일 prop과 className을 함께 사용할 때의 타입
export type StyleProps<T = {}> = T & {
  className?: string;
  style?: any;
};