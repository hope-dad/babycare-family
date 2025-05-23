import { Text, TouchableOpacity, TouchableOpacityProps } from "react-native";


interface AppButtonProps extends TouchableOpacityProps {
    title: string;
}

const AppButton: React.FC<AppButtonProps> = ({ title, ...props }) => (
  <TouchableOpacity
    className="h-[50px] bg-indigo-600 rounded-lg justify-center items-center mt-2"
    {...props}
  >
    <Text className="text-white font-semibold text-base">{title}</Text>
  </TouchableOpacity>
);

export default AppButton;