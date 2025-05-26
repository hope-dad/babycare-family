import { createApi } from '@reduxjs/toolkit/query/react';
import { axiosBaseQuery } from '../../services/api/interceptors';
export const baseApi = createApi({
    reducerPath: 'baseApi',
    baseQuery : axiosBaseQuery({baseUrl : ''}),
    tagTypes: [
        'User',
        'Baby',
        'Record',
        'Family',
        'Schedule',
        'Growth',
        'Fedding',
        'Sleep',
        'Diaper',
    ],
    endpoints: () => ({}),
});