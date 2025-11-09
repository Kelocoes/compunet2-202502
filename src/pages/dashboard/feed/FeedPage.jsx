import { Box, Typography } from "@mui/material";
import { useEffect, useState } from "react";

import Header from "../../../components/Header";
import userService from "../../../services/userService";
import UserCard from "../../../components/UserCard";

export default function FeedPage() {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const token = localStorage.getItem("token");
            const users = await userService.getAll(token);
            setUsers(users);
        };
        fetchData();
    }, []);

    return (
        <Box>
            <Header />
            <Typography variant="h3" color="primary">
                User Feed
            </Typography>

            <Box mt={2} sx={{ display: "flex", flexWrap: "wrap" }}>
                {users.map((user) => (
                    <UserCard key={user.id} user={user} />
                ))}
            </Box>
        </Box>
    );
}
