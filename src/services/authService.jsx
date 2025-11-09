import axiosInstance from "./axiosInstance";

const authService = {
    login: async (credentials) => {
        const response = await axiosInstance.post("/public/auth/login", credentials);
        return response.data;
    },
};

export default authService;
