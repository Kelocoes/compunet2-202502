const userService = {
    getAll: async (token) => {
        const response = await fetch("http://localhost:8082/compunet2-2025/api/users", {
            method: "GET",
            headers: {
                Authorization: `Bearer ${token}`,
            },
        });
        return await response.json();
    },
    getById: async (id, token) => {
        const response = await fetch(`http://localhost:8082/compunet2-2025/api/users/${id}`, {
            method: "GET",
            headers: {
                Authorization: `Bearer ${token}`,
            },
        });
        return await response.json();
    },
    create: async (userData, token) => {
        const response = await fetch("http://localhost:8082/compunet2-2025/api/users", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                Authorization: `Bearer ${token}`,
            },
            body: JSON.stringify(userData),
        });
        return await response.json();
    },
    update: async (id, userData, token) => {
        const response = await fetch(`http://localhost:8082/compunet2-2025/api/users/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
                Authorization: `Bearer ${token}`,
            },
            body: JSON.stringify(userData),
        });
        return await response.json();
    },
};

export default userService;
