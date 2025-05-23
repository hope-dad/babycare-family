import { useSelector } from 'react-redux';
import type { TypedUseSelectorHook } from 'react-redux';
import type { RootState } from '../redux/Store';

export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector;
