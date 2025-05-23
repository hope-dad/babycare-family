import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { RootStackParamList } from "./types";
import LoginScreen from "../screen/LoginScreen";

const Stack = createNativeStackNavigator<RootStackParamList>();


const Appnavigator = () => {
  <Stack.Navigator screenOptions={{ headerShown: false }}>
    <Stack.Screen name="Login" component={LoginScreen} />
  </Stack.Navigator>
}

export default Appnavigator;