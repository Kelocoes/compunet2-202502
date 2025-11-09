import { Box, Fab, Typography } from "@mui/material";
import { useEffect, useState } from "react";
import AddIcon from "@mui/icons-material/Add";

import userService from "../../../services/userService";
import UserCard from "../../../components/UserCard";
import CreateUserForm from "../../../components/CreateUserForm";

export default function FeedPage() {
    const [users, setUsers] = useState([]);
    const [openDialog, setOpenDialog] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            const users = await userService.getAll();
            setUsers(users);
        };
        fetchData();
    }, []);

    const handleOpenDialog = () => {
        setOpenDialog(true);
    };

    const handleCloseDialog = () => {
        setOpenDialog(false);
    };

    const handleCreateUser = async (userData) => {
        console.info("Crear usuario:", userData);
        try {
            const response = await userService.create(userData);
            setUsers((prevUsers) => [...prevUsers, response]);
        } catch (error) {
            console.error("Error creating user:", error);
        }

        handleCloseDialog();
    };

    return (
        <Box sx={{ display: "flex", flexDirection: "column" }}>
            <Typography variant="h3" color="primary" sx={{ mt: 4, mb: 2, textAlign: "center" }}>
                User Feed
            </Typography>

            <Box mt={2} sx={{ flexWrap: "wrap", display: "flex", gap: 2, justifyContent: "center" }}>
                {users.map((user) => (
                    <UserCard key={user.id} user={user} />
                ))}
            </Box>

            <Fab color="primary" aria-label="add" sx={{ position: "fixed", bottom: 16, right: 16 }} onClick={handleOpenDialog}>
                <AddIcon sx={{ fontSize: 32 }} />
            </Fab>

            <CreateUserForm open={openDialog} onClose={handleCloseDialog} onSubmit={handleCreateUser} />
        </Box>
    );
}
