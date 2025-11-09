const authService = {
    login: async (credentials) => {
        const response = await fetch("http://localhost:8082/compunet2-2025/api/public/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(credentials),
        });
        return await response.json();
    },
};

export default authService;
