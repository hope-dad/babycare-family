import { useDispatch } from 'react-redux';
import type { AppDispatch } from '../redux/Store';

export const useAppDispatch = () => useDispatch<AppDispatch>();
