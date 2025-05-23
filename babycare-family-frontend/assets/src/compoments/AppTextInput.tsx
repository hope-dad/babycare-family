// src/components/AppTextInput.tsx
import React from 'react';
import { TextInput, TextInputProps } from 'react-native';

type AppTextInputProps = TextInputProps;

const AppTextInput: React.FC<AppTextInputProps> = (props) => (
  <TextInput
    className="h-12 bg-white rounded-lg px-4 text-base mb-4 border border-gray-300"
    placeholderTextColor="#999"
    {...props}
  />
);

export default AppTextInput;
